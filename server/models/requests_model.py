from pydantic import BaseModel, Field
from datetime import datetime
from typing import Optional

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
