from fastapi import APIRouter, HTTPException

from ..models.tenants_model import Tenant
from ..config.database import db

from ..schemas.tenants_schema import tenants_serializer
from bson import ObjectId
import json

tenant_api_router = APIRouter()


# retrieve
@tenant_api_router.get("/")
async def get_tenants():
    tenants = tenants_serializer(db["tenant"].find())
    return {"status":"ok","data": tenants}

#get tenant details
@tenant_api_router.get("/{phone}")
async def get_tenant(phone:str):
    tenantDetails={}
    tenant = db["tenant"].find_one({"phone": int(phone)})
    tenantDetails["id"] = str(ObjectId(tenant["_id"]))
    tenantDetails["address"] = tenant["address"]
    tenantDetails["fcm"] = tenant["fcm"]
    tenantDetails["phone"] = tenant["phone"]
    return {"status":"ok","data": tenantDetails}

@tenant_api_router.post("/login")
async def create_tenant(tenant:Tenant):
    tenantDetails={}
    if(db["tenant"].find_one({"phone": tenant.phone})):
        tenants = db["tenant"].find_one({"phone": int(tenant.phone)})
        db["tenant"].update_one({"phone": int(tenant.phone)}, {
                                   "$set": {"address": tenant.address, "fcm": tenant.fcm}})
        tenantDetails["id"] = str(ObjectId(tenant["_id"]))
        tenantDetails["address"] = tenant["address"]
        tenantDetails["fcm"] = tenant["fcm"]
        tenantDetails["phone"] = tenant["phone"]
        return {"status":"ok","data": tenantDetails}
    else:
        db["tenant"].insert_one(dict(tenant))
        print(tenant)
        tenants = db["tenant"].find_one({"phone": int(tenant.phone)})
        tenantDetails["id"] = str(ObjectId(tenants["_id"]))
        tenantDetails["address"] = tenants["address"]
        tenantDetails["fcm"] = tenants["fcm"]
        tenantDetails["phone"] = tenants["phone"]
        return {"status":"ok","data": tenantDetails}
