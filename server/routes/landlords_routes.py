from fastapi import APIRouter

from models.landlords_model import Landlord
from config.database import collection_name

from schemas.landlords_schema import landlords_serializer, landlord_serializer
from bson import ObjectId
import json

landlord_api_router = APIRouter()


# retrieve
@landlord_api_router.get("/")
async def get_landlords():
    landlords = landlords_serializer(collection_name.find())
    return {"status":"ok","data": landlords}


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




