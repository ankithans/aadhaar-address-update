from fastapi import APIRouter, HTTPException

from ..models.tenants_model import Tenant
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
                                    "$set": {"address": tenant.address, "fcm": tenant.fcm, "uid": uid, "phone": tenant.phone}})
            tenants = db["tenant"].find_one({"uid": uid})
            tenantDetails["id"] = str(ObjectId(tenants["_id"]))
            tenantDetails["uid"] = tenants["uid"]
            tenantDetails["address"] = tenants["address"]
            tenantDetails["fcm"] = tenants["fcm"]
            tenantDetails["phone"] = tenants["phone"]
            return {"status": "ok", "data": tenantDetails}
        else:
            tenantdata = {}
            tenantdata["uid"] = uid
            tenantdata["address"] = tenant.address
            tenantdata["fcm"] = tenant.fcm
            tenantdata["phone"] = tenant.phone
            db["tenant"].insert_one(dict(tenantdata))
            tenants = db["tenant"].find_one({"uid": uid})
            tenantdata["id"] = str(ObjectId(tenants["_id"]))
            return {"status": "ok", "data": tenantdata}
    except Exception as e:
        print(e)
        raise HTTPException(status_code=400, detail=str(e))
