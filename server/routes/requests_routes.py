from fastapi import APIRouter, HTTPException
from datetime import datetime

from ..models.requests_model import Request
from ..models.status_model import Status
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
        if db["landlord"].find_one({"phone": int(request.landlord_uid)}):
            print("landlord exists")
        else:
            landlord={
                "address":"",
                "phone": request.landlord_uid,
                "fcm": "",
                "uid": ""
            }
            db["landlord"].insert_one(landlord)
        db["requests"].insert_one(dict(request))
        return {"status":"ok","data": request}
        # fcm token here

    except Exception as e:
        print(e)
        raise HTTPException(status_code=400, detail=str(e))

@request_api_router.post("/status_update")
async def status_update(status:Status):
    try:
        if status.approval_status: 
            updateStat = db["requests"].update_one({},{
                "$set":{
                    "status": 1,
                    "landlord_address": status.landlord_address,
                    "updated": status.updated
                }, "array_filters": [{"landlord_id": status.landlord_uid},{"status":0}]
            })
            print(updateStat)
        else:
            db["requests"].update_one({"landlord_id": status.landlord_uid},{
                "$set":{
                    "status": 2,
                    "updated": status.updated
                }
            })
        return {"status":"ok","data": status}
    except Exception as e:
        print(e)
        raise HTTPException(status_code=400, detail=str(e))