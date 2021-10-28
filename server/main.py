from fastapi import FastAPI
from .routes.landlords_routes import landlord_api_router
from .routes.tenants_routes import tenant_api_router
from .routes.requests_routes import request_api_router
from fastapi.middleware.cors import CORSMiddleware

tags_metadata = [
    {
        "name": "Landlords",
        "description": "Endpoints related to operations on the **Landlords**\
            collection."
    },
    {
        "name": "Tenant",
        "description": "Endpoints related to operations on the **Tenants**\
            collection."
    },
    {
        "name": "Request",
        "description": "Endpoints related to operations on the **Requests**\
            collection."
    }
]

app = FastAPI(
    title="Aadhar Address Update",
    description="Backend for the Aadhar Address Update",
    version="1.0",
    openapi_tags=tags_metadata
)

app.add_middleware(
    CORSMiddleware,
    allow_origins=["*"],
    allow_credentials=True,
    allow_methods=["*"],
    allow_headers=["*"],
)

app = FastAPI()

app.include_router(landlord_api_router,
                   prefix="/landlords", tags=["Landlords"])
app.include_router(tenant_api_router,
                   prefix="/tenants", tags=["Tenants"])
app.include_router(request_api_router,
                   prefix="/requests", tags=["Requests"])
