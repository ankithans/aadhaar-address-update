from pydantic import BaseModel, Field
from typing import Optional

class Tenant(BaseModel):
    # id: Optional[str] = Field(alias="_id")
    address: Optional[str]
    phone: int
    fcm: Optional[str]
    uid: Optional[str]