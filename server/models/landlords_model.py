from pydantic import BaseModel, Field
from typing import Optional

from server.models.address_model import Address

class Landlord(BaseModel):
    # id: Optional[str] = Field(alias="_id")
    address: Optional[str]
    phone: Optional[int]
    fcm: Optional[str]
    uid: Optional[str]