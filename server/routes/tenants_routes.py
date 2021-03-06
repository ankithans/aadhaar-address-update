from fastapi import APIRouter, HTTPException
from pymongo import response

from server.models.address_model import Address

from ..models.tenants_model import Tenant, UpdateAddress
from ..config.database import db, encrypt

from .requests_routes import addressvalidation

from ..auditLog.auditlog import pushAudit
from .requests_routes import sendPush

from ..schemas.tenants_schema import tenants_serializer
from bson.objectid import ObjectId


tenant_api_router = APIRouter()


# retrieve
# @tenant_api_router.get("/")
# async def get_tenants():
#     tenants = tenants_serializer(db["tenant"].find())
#     return {"status": "ok", "data": tenants}

# get tenant details


@tenant_api_router.get("/{tenant_uid}")
async def get_tenant(tenant_uid: str):
    try:
        uid = encrypt(tenant_uid)
        tenantDetails = {}
        tenant = db["tenant"].find_one({"uid": uid})
        tenantDetails["id"] = str(ObjectId(tenant["_id"]))
        tenantDetails["address"] = tenant["address"]
        tenantDetails["fcm"] = tenant["fcm"]
        tenantDetails["uid"] = tenant["uid"]
        tenantDetails["phone"] = tenant["phone"]
        description = "Tenant (id: " + \
            str(ObjectId(tenant["_id"]))+") called GET Tenat api"
        pushAudit("succesful", description)
        return {"status": "ok", "data": tenantDetails}
    except Exception as e:
        description = str(e)
        pushAudit("Error", description)
        print(e)
        raise HTTPException(status_code=400, detail=str(e))


@tenant_api_router.post("/login")
async def create_tenant(tenant: Tenant):
    try:
        tenantDetails = {}
        uid = encrypt(tenant.uid)
        if(db["tenant"].find_one({"uid": uid})):
            db["tenant"].update_one({"uid": uid}, {
                                    "$set": {"address": dict(tenant.address), "fcm": tenant.fcm, "uid": uid, "phone": tenant.phone}})
            tenants = db["tenant"].find_one({"uid": uid})
            tenantDetails["id"] = str(ObjectId(tenants["_id"]))
            tenantDetails["address"] = tenants["address"]
            tenantDetails["uid"] = tenant.uid
            tenantDetails["fcm"] = tenants["fcm"]
            tenantDetails["phone"] = tenants["phone"]
            description = "Tenant (id: " + \
                str(ObjectId(tenants["_id"]))+") logged in"
            pushAudit("succesful", description)
            return {"status": "ok", "data": tenantDetails}
        else:
            tenant.address = dict(tenant.address)
            tenant.uid = encrypt(tenant.uid)
            db["tenant"].insert_one(dict(tenant))
            tenants = db["tenant"].find_one({"phone": int(tenant.phone)})
            tenantDetails["id"] = str(ObjectId(tenants["_id"]))
            tenantDetails["address"] = tenants["address"]
            tenantDetails["fcm"] = tenants["fcm"]
            tenantDetails["uid"] = tenant.uid
            tenantDetails["phone"] = tenants["phone"]
            description = "Tenant (id: " + \
                str(ObjectId(tenants["_id"]))+") Signed up"
            pushAudit("succesful", description)
            return {"status": "ok", "data": tenantDetails}
    except Exception as e:
        print(e)
        description = str(e)
        pushAudit("Error", description)
        raise HTTPException(status_code=400, detail=str(e))


@tenant_api_router.post("/accept_address")
async def update_tenant_address(UpdateAddress: UpdateAddress):
    try:
        uid = encrypt(UpdateAddress.uid)
        tenant_id = db["tenant"].find_one({"uid": uid})
        request_id = db["requests"].find_one({"tenant_uid": uid, "status": 1})
        if request_id is None:
            description = "Fraudulent Case - Tenant (id: " + str(ObjectId(
                tenant_id["_id"]))+" ) made falls attempt to edit Request (" + str(ObjectId(request_id["_id"]))+")"
            pushAudit("Danger", description)
            return {"status": "400", "data": "No Address Update Permited"}
        res = await addressvalidation(UpdateAddress.landlordaddress, UpdateAddress.updatedaddress)
        if res:
            db["requests"].update_one({"_id": request_id["_id"]}, {
                "$set": {
                    "status": 3,
                    "landlord_address": dict(UpdateAddress.address),
                    "updated": ""
                }
            })
            tent = db["tenant"].find_one({"uid": uid})
            db["tenant"].update_one({"_id": tenant_id["_id"]}, {"$set": {"address": dict(UpdateAddress.address)}})
            sendPush(
                    "Request Completed",
                    "Your address has been updated Succesfully",
                    [tent['fcm']],
                )
            land = db["landlord"].find_one({"phone": request_id["landlord_no"]})
            sendPush(
                    "Request Completed",
                    "Your address has been sent Succesfully",
                    [land['fcm']],
                )
            description = "Tenant (id: "+str(ObjectId(
                tenant_id["_id"]))+" ) updated address Request (id: "+str(ObjectId(request_id["_id"]))+" )"
            pushAudit("succesful", description)
            return {"status": "200", "data": UpdateAddress.address}
        else:
            description = "Tenant (id: "+str(ObjectId(
                tenant_id["_id"]))+" ) update address Request (id: "+str(ObjectId(request_id["_id"]))+" ) denied due to to many changes in the address"
            pushAudit("Error", description)
            return {"status": "501", "data": "Unprocessible Entity"}
    except Exception as e:
        print(e)
        description = str(e)
        pushAudit("Error", description)
        raise HTTPException(status_code=400, detail=str(e))
