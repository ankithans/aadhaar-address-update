from pydantic import BaseModel, Field
from datetime import datetime
from typing import Optional

from pymongo import database

class Request(BaseModel):
    tenant_uid: str
    landlord_uid: Optional[str]
    landlord_no: Optional[int]
    status: int
    landlord_address: Optional[str]
    created: Optional[datetime]
    relation:str
    reason:str
    updated: datetime

class Requestedit(BaseModel):
    tenant_uid: str
    request_id: str
    reason: str
    relation:str
    updated: datetime

class Requestdelete(BaseModel):
    request_id: str
    tenant_uid: str

def requests_serializer(Requests) -> list:
    return [requests_serializer(request) for request in Requests]