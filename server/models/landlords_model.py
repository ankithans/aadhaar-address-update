from pydantic import BaseModel, Field
from typing import Optional

class Landlord(BaseModel):
    # id: Optional[str] = Field(alias="_id")
    address: Optional[str]
    phone: int
    fcm: Optional[str]
    class Config:
        allow_population_by_field_name = True