from fastapi import APIRouter, HTTPException
from datetime import datetime

from ..models.requests_model import Request, Requestdelete, Requestedit
from ..models.status_model import Status
from ..config.database import db

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
        land = db["landlord"].find_one({"phone": int(request.landlord_uid)})
        if land:
            print("landlord exists")
        else:
            landlord={
                "address":"",
                "phone": request.landlord_uid,
                "fcm": "",
                "uid": ""
            }
            db["landlord"].insert_one(landlord)
        
        # request.landlord_address = dict(request.landlord_address)
        db["requests"].insert_one(dict(request))

        if land:
            sendPush(
                "Tenant is requesting for address update.",
                "Do you agree and would like to give authoriy to update address?",
                land['fcm'],
            )

        return {"status":"ok","data": request}
        # fcm token here

    except Exception as e:
        print(e)
        raise HTTPException(status_code=400, detail=str(e))

@request_api_router.post("/status_update")
async def status_update(status:Status):
    try:
        request_id=db["requests"].find_one({"landlord_uid": status.landlord_uid},{"status":0})
        if status.approval_status: 
            updateStat = db["requests"].update_one({"_id":request_id["_id"]},{
                "$set":{
                    "status": 1,
                    "landlord_address": dict(status.landlord_address),
                    "updated": status.updated
                }
            })
            print(updateStat)
        else:
            db["requests"].update_one({"_id":request_id["_id"]},{
                "$set":{
                    "status": 2,
                    "updated": status.updated,
                    "landlord_address":""
                }
            })
        return {"status":"ok","data": status}
    except Exception as e:
        print(e)
        raise HTTPException(status_code=400, detail=str(e))

@request_api_router.get("/landlord/{landlord_uid}")
async def get_landlord_requests(landlord_uid:str):
    try:
        requests = requests_serializer(db["requests"].find({"landlord_uid": str(landlord_uid)}))
        return {"status": "ok", "data": requests}
    except Exception as e:
        print(e)
        raise HTTPException(status_code=400, detail=str(e))

@request_api_router.get("/tenant/{tenant_uid}")
async def get_tenant_requests(tenant_uid:str):
    try:
        requests = requests_serializer(db["requests"].find({"tenant_uid": str(tenant_uid)}))
        return {"status": "ok", "data": requests}
    except Exception as e:
        print(e)
        raise HTTPException(status_code=400, detail=str(e))

@request_api_router.put("/")
async def request_edit(Requestedit:Requestedit):
    try:
        request = db["requests"].find_one({"_id":ObjectId(Requestedit.request_id),"status": 0})
        if str(request["tenant_uid"]) == str(Requestedit.tenant_uid):
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
        if str(request["tenant_uid"]) == str(Requestdelete.tenant_uid):
            db["requests"].delete_one({"_id":ObjectId(Requestdelete.request_id)})
            return {"status":"ok", "data": "request deleted"}
        else:
            raise HTTPException(status_code=401, data="User not authorised")
    except Exception as e:
        print(e)
        raise HTTPException(status_code=400, detail=str(e))