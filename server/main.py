from fastapi import FastAPI
from .routes.landlords_routes import landlord_api_router

app = FastAPI()

app.include_router(landlord_api_router)

