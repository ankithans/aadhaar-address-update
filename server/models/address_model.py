from pydantic import BaseModel
from typing import Optional

class Address(BaseModel):
    co: Optional[str]
    country: Optional[str]
    dist: Optional[str]
    house: Optional[str]
    lm: Optional[str]
    loc: Optional[str]
    pc: Optional[str]
    state: Optional[str]
    vtc: Optional[str]
    street: Optional[str]