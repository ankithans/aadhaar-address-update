from pydantic import BaseModel
from typing import Optional

from server.models.address_model import Address

class Tenant(BaseModel):
    # id: Optional[str] = Field(alias="_id")
    address: Address
    phone: int
    fcm: Optional[str]
    uid: Optional[str]

class UpdateAddress(BaseModel):
    address: Address
    uid: str
    landlordaddress: str
    updatedaddress: str