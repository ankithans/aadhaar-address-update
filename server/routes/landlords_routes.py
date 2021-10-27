from fastapi import APIRouter, HTTPException

from ..models.landlords_model import Landlord
from ..config.database import collection_name

from ..schemas.landlords_schema import landlords_serializer
from bson import ObjectId



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


@landlord_api_router.get("/{phone}")
async def get_landlord(phone: str):
    try:
        landlordDetails = {}
        landlord = collection_name.find_one({"phone": int(phone)})
        landlordDetails["id"] = str(ObjectId(landlord["_id"]))
        landlordDetails["address"] = landlord["address"]
        landlordDetails["fcm"] = landlord["fcm"]
        landlordDetails["phone"] = landlord["phone"]
        return {"status": "ok", "data": landlordDetails}
    except Exception as e:
        print(e)
        raise HTTPException(status_code=400, detail=str(e))


@landlord_api_router.post("/login")
async def create_landlord(landlord: Landlord):
    try:
        landlordDetails = {}
        if(collection_name.find_one({"phone": landlord.phone})):
            collection_name.update_one({"phone": int(landlord.phone)}, {
                                    "$set": {"address": landlord.address, "fcm": landlord.fcm}})
            landlords = collection_name.find_one({"phone": int(landlord.phone)})
            landlordDetails["id"] = str(ObjectId(landlords["_id"]))
            landlordDetails["address"] = landlords["address"]
            landlordDetails["fcm"] = landlords["fcm"]
            landlordDetails["phone"] = landlords["phone"]
            return {"status": "ok", "data": landlordDetails}
        else:
            collection_name.insert_one(dict(landlord))
            landlords = collection_name.find_one({"phone": int(landlord.phone)})
            landlordDetails["id"] = str(ObjectId(landlords["_id"]))
            landlordDetails["address"] = landlords["address"]
            landlordDetails["fcm"] = landlords["fcm"]
            landlordDetails["phone"] = landlords["phone"]
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
