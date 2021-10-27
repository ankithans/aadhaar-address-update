from pydantic import BaseModel, Field
from datetime import datetime
from typing import Optional

class Request(BaseModel):
    tenant_id: str
    landlord_id: str
    status: int
    landord_address: str
    created: datetime