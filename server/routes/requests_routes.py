from fastapi import APIRouter, HTTPException
from server.auditLog.auditlog import pushAudit

from server.models.address_model import Address
from server.schemas.tenants_schema import tenants_serializer

from ..models.requests_model import Request, Requestdelete, Requestedit
from ..models.status_model import Status
from ..config.database import db, encrypt, decrypt

from ..schemas.requests_schema import requests_serializer
from bson.objectid import ObjectId
#import FCMManager as fcm
import json
import firebase_admin
from firebase_admin import credentials, messaging
import os
import sys

request_api_router = APIRouter()


dir = os.path.dirname(__file__)
filename = os.path.join(dir, "serviceaccountkey.json")
print(filename)
cred = credentials.Certificate(filename)
firebase_admin.initialize_app(cred)


def sendPush(title, msg, registration_token, dataObject=None):
    message = messaging.MulticastMessage(
        notification=messaging.Notification(
            title=title,
            body=msg
        ),
        data=dataObject,
        tokens=registration_token,
    )
    response = messaging.send_multicast(message)

    print("Successfully sent message:", response)


# @request_api_router.get("/")
# async def get_requests():
#     try:
#         request = requests_serializer(db["requests"].find())
#         return {"status":"ok","data": request}
#     except Exception as e:
#         print(e)
#         raise HTTPException(status_code=400, detail=str(e))


# @request_api_router.post("/")
# async def create_request(request: Request):
#     try:
#         uid = ""
#         phone = ""
#         tenant_uid = encrypt(request.tenant_uid)
#         tenant_id =db["tenant"].find_one({uid: tenant_uid})
#         if request.landlord_uid:
#             if request.landlord_uid == request.tenant_uid:
#                 description = "Fraudulent Case - Tenant (id: " + str(ObjectId(
#                     tenant_id["_id"]))+" ) made falls attempt to Create Request, Tenant and landlord are same. "
#                 pushAudit("Danger", description)
#                 return {"status": "400", "data": "tenant and landlord cannot be same."}
#             uid = encrypt(request.landlord_uid)
#             land = db["landlord"].find_one({"uid": uid})
#             if land:
#                 print("landlord exists")
#                 sendPush(
#                     "Tenant is requesting for address update.",
#                     "Do you agree and would like to give authoriy to update address?",
#                     [land['fcm']],
#                 )
#         elif request.landlord_no:
#             phone = request.landlord_no
#             land = db["landlord"].find_one({"phone": phone})
#             if decrypt(land["uid"]) == request.tenant_uid:
#                 return {"status": "400", "data": "tenant and landlord cannot be same."}
#             if land:
#                 print("landlord exists")
#                 sendPush(
#                     "Tenant is requesting for address update.",
#                     "Do you agree and would like to give authoriy to update address?",
#                     [land['fcm']],
#                 )
#         else:
#             landlord = {
#                 "address": "",
#                 "phone": phone,
#                 "fcm": "",
#                 "uid": uid
#             }
#             db["landlord"].insert_one(landlord)

#         request.landlord_address = dict(request.landlord_address)
#         request.tenant_uid = encrypt(request.tenant_uid)
#         request.landlord_uid = uid
#         db["requests"].insert_one(dict(request))

#         return {"status": "ok", "data": request}

#     except Exception as e:
#         print(e)
#         raise HTTPException(status_code=400, detail=str(e))


@request_api_router.post("/")
async def create_request(request: Request):
    try:
        uid = ""
        phone = ""
        print(request)
        tenant_uid = encrypt(request.tenant_uid)
        tenant_id =db["tenant"].find_one({"uid": tenant_uid})
        if len(request.landlord_uid) == 12:
            uid = encrypt(request.landlord_uid)
            land = db["landlord"].find_one({"uid": uid})
            if land:
                if request.landlord_uid == request.tenant_uid:
                    description = "Fraudulent Case - Tenant (id: " + str(ObjectId(
                        tenant_id["_id"]))+" ) made falls attempt to Create Request, Tenant and landlord are same. "
                    pushAudit("Danger", description)
                    return {"status": "400", "data": "tenant and landlord cannot be same."}
                sendPush(
                    "Tenant is requesting for address update.",
                    "Do you agree and would like to give authoriy to update address?",
                    [land['fcm']],
                )
        elif request.landlord_no:
            # print(request.)
            phone = request.landlord_no
            land = db["landlord"].find_one({"phone": phone})
            print(land)
            if land:
                if decrypt(land["uid"]) == request.tenant_uid:
                    description = "Fraudulent Case - Tenant (id: " + str(ObjectId(
                        tenant_id["_id"]))+" ) made falls attempt to Create Request, Tenant and landlord are same. "
                    pushAudit("Danger", description)
                    return {"status": "400", "data": "tenant and landlord cannot be same."}
                if land:
                    sendPush(
                    "Tenant is requesting for address update.",
                    "Do you agree and would like to give authoriy to update address?",
                    [land['fcm']],
                    )
            else:
                landlord = {
                "address": "",
                "phone": phone,
                "fcm": "",
                    "uid": uid
                    }
                landlord_id = db["landlord"].insert_one(landlord)
                description = "Landlord (id: "+str(ObjectId(landlord_id["_id"]))+") Created"
                pushAudit("succesful", description)
        else:
            description = "Tenant (id: "+str(ObjectId(tenant_id["_id"]))+") called CREATE REQUEST api without Landlord Details"
            pushAudit("Danger", description)
            return {"status":"Unprocessable Entity", "data":"No Landlord Details"}

        request.landlord_address = dict(request.landlord_address)
        request.tenant_uid = encrypt(request.tenant_uid)
        request.landlord_uid = uid
        request_id = db["requests"].insert_one(dict(request))
        description = "Tenant (id: "+str(ObjectId(tenant_id["_id"]))+") made request (id: "+str(ObjectId(request_id["_id"]))+" ) to Landlord (id: "+str(ObjectId(land["_id"]))+" )"
        pushAudit("Succesful", description)
        return {"status": "ok", "data": request}

    except Exception as e:
        print(e)
        description = str(e)
        pushAudit("Error", description)
        raise HTTPException(status_code=400, detail=str(e))


@request_api_router.post("/status_update")
async def status_update(status: Status):
    try:
        request_id = db["requests"].find_one(
            {"_id": ObjectId(status.id)}, {"status": 0})
        landlord_id = db["landlord"].find_one({
            "uid":encrypt(status.landlord_uid)
        })
        if request_id is None:
            description = "Fraudulent Case - Landlord (id: "+str(ObjectId(landlord_id["_id"]))+") make falls attempt to change status of Request (id: "+ status.id+ ")"
            pushAudit("Danger", description)
            return {"status": "400", "data": "No In-Progress Request Found"}

        tenant_uid = request_id['tenant_uid']
        tenant_id = db["tenant"].find_one({"uid": tenant_uid})
        tenant = db['tenant'].find_one({"uid": tenant_uid})

        if status.approval_status:
            landlord_uid = request_id["landlord_uid"]
            landlord = db["landlord"].find_one({"uid": landlord_uid})
            if landlord is None:
                return {"status": "400", "data": "No landlord found"}

            updateStatus = db["requests"].update_one({"_id": request_id["_id"]}, {
                "$set": {
                    "status": 1,
                    "landlord_address": landlord['address'],
                    "updated": status.updated
                }
            })
            description = "Landlord (id: "+str(ObjectId(landlord_id["_id"]))+") approved to share address to Tenant (id: "+ str(ObjectId(tenant_id["_id"]))+") Request (id: "+ status.id+ ")"
            pushAudit("Successful", description)

            if tenant:
                sendPush(
                    "Congratulations! Landlord approved your request.",
                    "Please follow the next steps to update your address.",
                    [tenant['fcm']],
                )
        else:
            address = {
                "co": "",
                "country": "",
                "dist": "",
                "house": "",
                "lm": "",
                "loc": "",
                "pc": "",
                "state": "",
                "vtc": "",
                "street": ""
            }
            db["requests"].update_one({"_id": request_id["_id"]}, {
                "$set": {
                    "status": 2,
                    "updated": status.updated,
                    "landlord_address": dict(address)
                }
            })
            description = "Landlord (id: "+str(ObjectId(landlord_id["_id"]))+") Denied to share address to Tenant (id: "+ str(ObjectId(tenant_id["_id"]))+") Request (id: "+ status.id+ ")"
            pushAudit("Successful", description)
            if tenant:
                sendPush(
                    "We are sorry! Your request is rejected by Landlord",
                    "You can create new request with appropriate details.",
                    [tenant['fcm']],
                )
        return {"status": "ok", "data": status}
    except Exception as e:
        print(e)
        description = str(e)
        pushAudit("Error", description)
        raise HTTPException(status_code=400, detail=str(e))


@request_api_router.get("/landlord/{landlord_uid}")
async def get_landlord_requests(landlord_uid):
    try:
        uid = encrypt(landlord_uid)
        requests = requests_serializer(
            db["requests"].find({"landlord_uid": uid}))
        landlord_id = db["landlord"].find_one({"uid": uid})
        description = "Landlord (id: "+str(ObjectId(landlord_id["_id"]))+") called GET LANDLORD REQUESTS"
        pushAudit("Successful", description)
        return {"status": "ok", "data": requests}
    except Exception as e:
        print(e)
        description = str(e)
        pushAudit("Error", description)
        raise HTTPException(status_code=400, detail=str(e))


@request_api_router.get("/tenant/{tenant_uid}")
async def get_tenant_requests(tenant_uid):
    try:
        uid = encrypt(tenant_uid)
        tenant_id = db["tenant"].find_one({"uid": uid})
        requests = requests_serializer(
            db["requests"].find({"tenant_uid": uid}))
        description = "Landlord (id: "+str(ObjectId(tenant_id["_id"]))+") called GET TENANT REQUESTS"
        pushAudit("Successful", description)
        return {"status": "ok", "data": requests}
    except Exception as e:
        print(e)
        description = str(e)
        pushAudit("Error", description)
        raise HTTPException(status_code=400, detail=str(e))


@request_api_router.put("/")
async def request_edit(Requestedit: Requestedit):
    try:
        request = db["requests"].find_one(
            {"_id": ObjectId(Requestedit.request_id), "status": 0})
        tenant_id = db["tenant"].find_one({"uid":request["tenant_uid"]})
        if request["tenant_uid"] == encrypt(Requestedit.tenant_uid):
            db["requests"].update_one({"_id": ObjectId(Requestedit.request_id)}, {
                "$set": {
                    "updated": Requestedit.updated,
                    "reason": Requestedit.reason,
                    "relation": Requestedit.relation
                }
            })
            landlord_uid = request['landlord_uid']
            landlord_id = db["landlord"].find_one({"uid": landlord_uid})
            description = "Tenant (id: "+str(ObjectId(tenant_id["_id"]))+") edited address from Landlord (id: "+ str(ObjectId(landlord_id["_id"]))+") Request (id: "+ str(ObjectId(request["_id"]))+ ")"
            pushAudit("Successful", description)
            if landlord_id:
                sendPush(
                    "Tenant updated the request.",
                    "Do you agree and would like to give authoriy to update address?",
                    [landlord_id['fcm']],
                )
            return {"status": "ok", "data": "request updated"}
        description = "Fraudulent Case - Tenant (id: "+str(ObjectId(tenant_id["_id"]))+") made falls attempt to edit Request (id: "+ str(ObjectId(request["_id"]))+ "), Unauthorized"
        pushAudit("Danger", description)
        return {"status": "401", "data": "user not authorized"}
    except Exception as e:
        print(e)
        description = str(e)
        pushAudit("Error", description)
        raise HTTPException(status_code=400, detail=str(e))


@request_api_router.delete("/")
async def delete_request(Requestdelete: Requestdelete):
    try:
        request = db["requests"].find_one(
            {"_id": ObjectId(Requestdelete.request_id)})
        tenant_id = db["tenant"].find_one({"uid":request["tenant_uid"]})
        if request["tenant_uid"] == encrypt(Requestdelete.tenant_uid):
            db["requests"].delete_one(
                {"_id": ObjectId(Requestdelete.request_id)})
            description = "Tenant (id: "+str(ObjectId(tenant_id["_id"]))+") deleted Request (id: "+ str(ObjectId(request["_id"]))+ " )"
            pushAudit("Successful", description)
            return {"status": "ok", "data": "request deleted"}
        else:
            description = "Fraudulent Case - Tenant (id: "+str(ObjectId(tenant_id["_id"]))+") made falls attempt to delete Request (id: "+ str(ObjectId(request["_id"]))+ "), Unauthorized"
            pushAudit("Danger", description)
            raise HTTPException(status_code=401, data="User not authorised")
    except Exception as e:
        print(e)
        description = str(e)
        pushAudit("Error", description)
        raise HTTPException(status_code=400, detail=str(e))
