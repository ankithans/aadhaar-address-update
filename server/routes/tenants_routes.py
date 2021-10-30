from fastapi import APIRouter, HTTPException

from server.models.address_model import Address

from ..models.tenants_model import Tenant, UpdateAddress
from ..config.database import db, encrypt

from ..schemas.tenants_schema import tenants_serializer
from bson.objectid import ObjectId


import json

tenant_api_router = APIRouter()


# retrieve
@tenant_api_router.get("/")
async def get_tenants():
    tenants = tenants_serializer(db["tenant"].find())
    return {"status": "ok", "data": tenants}

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
        return {"status": "ok", "data": tenantDetails}
    except Exception as e:
        print(e)
        raise HTTPException(status_code=400, detail=str(e))


@tenant_api_router.post("/login")
async def create_landlord(tenant: Tenant):
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
            return {"status": "ok", "data": tenantDetails}
    except Exception as e:
        print(e)
        raise HTTPException(status_code=400, detail=str(e))


@tenant_api_router.post("/accept_address")
async def update_tenant_address(UpdateAddress: UpdateAddress):
    try:
        uid = encrypt(UpdateAddress.uid)
        request_id = db["requests"].find_one({"tenant_uid": uid, "status": 1})
        if request_id is None:
            return {"status": "400", "data": "No Address Update Permited"}
        if UpdateAddress.address.house and request_id["landlord_address"]["country"] == UpdateAddress.address.country and request_id["landlord_address"]["dist"] == UpdateAddress.address.dist and request_id["landlord_address"]["lm"] == UpdateAddress.address.lm and request_id["landlord_address"]["loc"] == UpdateAddress.address.loc and request_id["landlord_address"]["pc"] == UpdateAddress.address.pc and request_id["landlord_address"]["state"] == UpdateAddress.address.state and request_id["landlord_address"]["vtc"] == UpdateAddress.address.vtc and request_id["landlord_address"]["street"] == UpdateAddress.address.street:
            db["tenant"].update_one({"uid":uid}, {"$set":{
                "address": dict(UpdateAddress.address),
                "status":3
            }})
            return {"status":"200","data":UpdateAddress.address}
        else:
            return {"status":"501","data":"Unprocessible Entity"}
    except Exception as e:
        print(e)
        raise HTTPException(status_code=400, detail=str(e))
