from fastapi import APIRouter, HTTPException

from ..models.requests_model import Request
from ..config.database import db

from ..schemas.requests_schema import requests_serializer
from bson.objectid import ObjectId


import json

request_api_router = APIRouter()

@request_api_router.get("/")
async def get_requests():
    try:
        request = requests_serializer(db["requests"].find())
        return {"status":"ok","data": request}
    except Exception as e:
        print(e)
        raise HTTPException(status_code=400, detail=str(e))


@request_api_router.post("/")
async def create_tenant(request:Request):
    try:
        if db["landlord"].find_one({"phone": int(request.landlord_id)}):
            print("landlord exists")
        else:
            landlord={
                "address":"",
                "phone": request.landlord_id,
                "fcm": ""
            }
            db["landlord"].insert_one(landlord)
        db["requests"].insert_one(dict(request))
        return {"status":"ok","data": request}
        # fcm token here

    except Exception as e:
        print(e)
        raise HTTPException(status_code=400, detail=str(e))
