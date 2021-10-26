from pydantic import BaseModel

class Landlord(BaseModel):
    name: str
    description: str
    completed: bool
    date: str