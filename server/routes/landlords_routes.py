from fastapi import APIRouter, HTTPException

from ..models.landlords_model import Landlord
from ..config.database import collection_name, encrypt, decrypt

from ..schemas.landlords_schema import landlords_serializer
from bson.objectid import ObjectId

import json

landlord_api_router = APIRouter()


# retrieve
@landlord_api_router.get("/")
async def get_landlords():
    try:
        landlords = landlords_serializer(collection_name.find())
        return {"status": "ok", "data": landlords}
    except Exception as e:
        print(e)
        raise HTTPException(status_code=400, detail=str(e))

# get landlord details


@landlord_api_router.get("/{Landlord_uid}")
async def get_landlord(Landlord_uid):
    try:
        uid = encrypt(Landlord_uid)
        print(uid)
        landlordDetails = {}
        landlord = collection_name.find_one({"uid": uid})
        landlordDetails["id"] = str(ObjectId(landlord["_id"]))
        landlordDetails["address"] = landlord["address"]
        landlordDetails["fcm"] = landlord["fcm"]
        landlordDetails["uid"] = landlord["uid"]
        landlordDetails["phone"] = landlord["phone"]
        return {"status": "ok", "data": landlordDetails}
    except Exception as e:
        print(e)
        raise HTTPException(status_code=400, detail=str(e))

# b'$2b$12$VWXW6zS2m3WY/GBx8Vo8h.2nlCmqu0Z9MRmnaCXzffw/94k5Z.ZKi'
#


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
            return {"status": "ok", "data": landlordDetails}
    except Exception as e:
        print(e)
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
