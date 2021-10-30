from pymongo import MongoClient
from dotenv import load_dotenv
import base64
import os

load_dotenv()
MONGO_CLIENT_URL=os.getenv("MONGO_CLIENT_URL")

client = MongoClient(MONGO_CLIENT_URL, tls=True, tlsAllowInvalidCertificates=True)

def encrypt(text):
    encode= text.encode('ascii')
    encoded = base64.b64encode(encode)
    encoded_string = encoded.decode("ascii")
    return encoded_string

def decrypt(text):
    decode = text.encode("ascii")
    decoded = base64.b64decode(decode)
    decoded_string = decoded.decode("ascii")
    return decoded_string


db = client.aadhar_address_update_new

collection_name = db["landlord"]