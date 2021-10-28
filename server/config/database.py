from pymongo import MongoClient
from dotenv import load_dotenv
import bcrypt
import os

load_dotenv()
MONGO_CLIENT_URL=os.getenv("MONGO_CLIENT_URL")

client = MongoClient(MONGO_CLIENT_URL)

def encrypt(text):
    salt = bcrypt.gensalt()
    hashed = bcrypt.hashpw(text, salt)
    return hashed

def checkencrypt(text ,hashed):
    return bcrypt.checkpw(text, hashed)


db = client.aadhar_address_update_new

collection_name = db["landlord"]