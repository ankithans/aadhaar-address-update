from fastapi import APIRouter, HTTPException
from datetime import datetime

from ..models.requests_model import Request, Requestdelete, Requestedit
from ..models.status_model import Status
from ..config.database import db, encrypt, decrypt

from ..schemas.requests_schema import requests_serializer
from bson.objectid import ObjectId
#import FCMManager as fcm
import json
import firebase_admin
from firebase_admin import credentials,messaging
import os
import sys

request_api_router = APIRouter()



dir = os.path.dirname(__file__)
filename = os.path.join(dir, "serviceaccountkey.json")
print(filename)
cred =credentials.Certificate(filename)
firebase_admin.initialize_app(cred)

def sendPush(title,msg,registration_token,dataObject=None):
    message=messaging.MulticastMessage(
        notification=messaging.Notification(
            title=title,
            body=msg
        ),
        data=dataObject,
        tokens=registration_token,
    )
    response=messaging.send_multicast(message)

    print("Successfully sent message:",response)




@request_api_router.get("/")
async def get_requests():
    try:
        request = requests_serializer(db["requests"].find())
        return {"status":"ok","data": request}
    except Exception as e:
        print(e)
        raise HTTPException(status_code=400, detail=str(e))


@request_api_router.post("/")
async def create_request(request:Request):
    try:
        uid = ""
        phone = ""
        if request.landlord_uid:
            if request.landlord_uid == request.tenant_uid:
                return {"status": "400", "data": "tenant and landlord cannot be same."}
            uid = encrypt(request.landlord_uid)
            land = db["landlord"].find_one({"uid": uid})
            if land:
                print("landlord exists")
                sendPush(
                    "Tenant is requesting for address update.",
                    "Do you agree and would like to give authoriy to update address?",
                    land['fcm'],
                )
        elif request.landlord_no:
            phone = request.landlord_no
            land = db["landlord"].find_one({"phone": phone})
            if decrypt(land["uid"]) == request.tenant_uid:
                return {"status": "400", "data": "tenant and landlord cannot be same."}
            if land:
                print("landlord exists")
                sendPush(
                    "Tenant is requesting for address update.",
                    "Do you agree and would like to give authoriy to update address?",
                    land['fcm'],
                )
        else:
            landlord={
                "address":"",
                "phone": phone,
                "fcm": "",
                "uid": uid
            }
            db["landlord"].insert_one(landlord)
        
        request.landlord_address = dict(request.landlord_address)
        request.tenant_uid = encrypt(request.tenant_uid)
        request.landlord_uid = uid
        db["requests"].insert_one(dict(request))

        return {"status":"ok","data": request}
        # fcm token here

    except Exception as e:
        print(e)
        raise HTTPException(status_code=400, detail=str(e))

@request_api_router.post("/status_update")
async def status_update(status:Status):
    try:
        uid = encrypt(status.landlord_uid)
        request_id=db["requests"].find_one({"landlord_uid": uid},{"status":0})
        if status.approval_status: 
            updateStat = db["requests"].update_one({"_id":ObjectId(request_id["_id"])},{
                "$set":{
                    "status": 1,
                    "landlord_address": dict(status.landlord_address),
                    "updated": status.updated
                }
            })
            print(updateStat)
        else:
            db["requests"].update_one({"_id":ObjectId(request_id["_id"])},{
                "$set":{
                    "status": 2,
                    "updated": status.updated,
                    "landlord_address":{}
                }
            })
        return {"status":"ok","data": status}
    except Exception as e:
        print(e)
        raise HTTPException(status_code=400, detail=str(e))

@request_api_router.get("/landlord/{landlord_uid}")
async def get_landlord_requests(landlord_uid):
    try:
        uid = encrypt(landlord_uid)
        requests = requests_serializer(db["requests"].find({"landlord_uid": uid}))
        return {"status": "ok", "data": requests}
    except Exception as e:
        print(e)
        raise HTTPException(status_code=400, detail=str(e))

@request_api_router.get("/tenant/{tenant_uid}")
async def get_tenant_requests(tenant_uid):
    try:
        uid = encrypt(tenant_uid)
        requests = requests_serializer(db["requests"].find({"tenant_uid": uid}))
        print(requests)
        return {"status": "ok", "data": requests}
    except Exception as e:
        print(e)
        raise HTTPException(status_code=400, detail=str(e))

@request_api_router.put("/")
async def request_edit(Requestedit:Requestedit):
    try:
        request = db["requests"].find_one({"_id":ObjectId(Requestedit.request_id),"status": 0})
        if encrypt(request["tenant_uid"]) == encrypt(Requestedit.tenant_uid):
            db["requests"].update_one({"_id":ObjectId(Requestedit.request_id)},{
                "$set":{
                    "updated": Requestedit.updated,
                    "reason": Requestedit.reason,
                    "relation":Requestedit.relation
                }
            })
            return {"status":"ok", "data": "request updated"}
    except Exception as e:
        print(e)
        raise HTTPException(status_code=400, detail=str(e))

@request_api_router.delete("/")
async def delete_request(Requestdelete:Requestdelete):
    try:
        request = db["requests"].find_one({"_id":ObjectId(Requestdelete.request_id)})
        if encrypt(request["tenant_uid"]) == encrypt(Requestedit.tenant_uid):
            db["requests"].delete_one({"_id":ObjectId(Requestdelete.request_id)})
            return {"status":"ok", "data": "request deleted"}
        else:
            raise HTTPException(status_code=401, data="User not authorised")
    except Exception as e:
        print(e)
        raise HTTPException(status_code=400, detail=str(e))