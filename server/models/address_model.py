from pydantic import BaseModel

class Address(BaseModel):
    co: str
    country: str
    dist: str
    house: str
    lm: str
    loc: str
    pc: str
    state: str
    vtc: str