from pydantic import BaseModel, Field
from datetime import datetime
from typing import Optional

from server.models.address_model import Address

class Status(BaseModel):
    landlord_uid: str
    approval_status: bool
    landlord_address: Address
    updated: datetime