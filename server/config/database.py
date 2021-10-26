from pymongo import MongoClient



client = MongoClient("mongodb+srv://Aryamaan:uidaii@cluster0.pgnqe.mongodb.net/myFirstDatabase?retryWrites=true&w=majority")


db = client.aadhar_address_update_new

collection_name = db["landlord"]