from fastapi import APIRouter, HTTPException

from ..models.landlords_model import Landlord
from ..config.database import collection_name, encrypt
from ..auditLog.auditlog import pushAudit

from ..schemas.landlords_schema import landlords_serializer
from bson.objectid import ObjectId

import json

landlord_api_router = APIRouter()


# retrieve
# @landlord_api_router.get("/")
# async def get_landlords():
#     try:
#         landlords = landlords_serializer(collection_name.find())
#         return {"status": "ok", "data": landlords}
#     except Exception as e:
#         print(e)
#         raise HTTPException(status_code=400, detail=str(e))

# get landlord details


@landlord_api_router.get("/{Landlord_uid}")
async def get_landlord(Landlord_uid):
    try:
        uid = encrypt(Landlord_uid)
        landlordDetails = {}
        landlord = collection_name.find_one({"uid": uid})
        landlordDetails["id"] = str(ObjectId(landlord["_id"]))
        print(str(ObjectId(landlord["_id"])))
        landlordDetails["address"] = landlord["address"]
        landlordDetails["fcm"] = landlord["fcm"]
        landlordDetails["uid"] = landlord["uid"]
        landlordDetails["phone"] = landlord["phone"]
        status = "succesful"
        description = "Landlord (id: "+str(ObjectId(landlord["_id"]))+") called GET LANDLORD api"
        pushAudit(status,description)
        return {"status": "ok", "data": landlordDetails}
    except Exception as e:
        print(e)
        status = "Error"
        description = str(e)
        pushAudit(status,description)
        raise HTTPException(status_code=400, detail=str(e))


@landlord_api_router.post("/login")
async def create_landlord(landlord: Landlord):
    try:
        landlordDetails = {}
        uid = encrypt(landlord.uid)
        if(collection_name.find_one({"uid": uid})):
            collection_name.update_one({"uid": uid}, {
                "$set": {"address": dict(landlord.address), "fcm": landlord.fcm, "uid": uid, "phone": landlord.phone}})
            landlords = collection_name.find_one(
                {"uid": uid})
            landlordDetails["id"] = str(ObjectId(landlords["_id"]))
            landlordDetails["address"] = landlords["address"]
            landlordDetails["fcm"] = landlords["fcm"]
            landlordDetails["phone"] = landlords["phone"]
            landlordDetails["uid"] = landlord.uid
            description = "Landlord (id: "+str(ObjectId(landlords["_id"]))+") logged in"
            pushAudit("succesful", description)
            return {"status": "ok", "data": landlordDetails}
        else:
            landlord.address = dict(landlord.address)
            landlord.uid = encrypt(landlord.uid)
            collection_name.insert_one(dict(landlord))
            landlords = collection_name.find_one(
                {"phone": int(landlord.phone)})
            landlordDetails["id"] = str(ObjectId(landlords["_id"]))
            landlordDetails["address"] = landlords["address"]
            landlordDetails["fcm"] = landlords["fcm"]
            landlordDetails["phone"] = landlords["phone"]
            landlordDetails["uid"] = landlord.uid
            description = "Landlord (id: "+str(ObjectId(landlords["_id"]))+") signed up"
            pushAudit("succesful", description)
            return {"status": "ok", "data": landlordDetails}
    except Exception as e:
        print(e)
        description = str(e)
        pushAudit("Error", description)
        raise HTTPException(status_code=400, detail=str(e))


"""

@landlord_api_router.get("/{id}")
async def get_landlord(id:str):
    landlord=landlords_serializer(collection_name.find_one({"_id": ObjectId(id)}))
    return {"status":"ok","data": landlord}

@landlord_api_router.post("/")
async def create_landlord(landlord: Landlord):
    _id =collection_name.insert_one(dict(landlord))
    landlord=landlords_serializer(collection_name.find_one({"_id":_id.inserted_id}))
    return {"status":"ok","data":landlord}

"""
