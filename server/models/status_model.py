from pydantic import BaseModel, Field
from datetime import datetime
from typing import Optional

class Status(BaseModel):
    landlord_uid: str
    approval_status: bool
    landlord_address: Optional[str]
    updated: datetime