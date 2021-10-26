from pymongo import MongoClient
from dotenv import load_dotenv
import os

load_dotenv()
MONGO_CLIENT_URL=os.getenv("MONGO_CLIENT_URL")

client = MongoClient(MONGO_CLIENT_URL, tls=True, tlsAllowInvalidCertificates=True)


db = client.aadhar_address_update_new

collection_name = db["landlord"]