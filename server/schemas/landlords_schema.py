def landlord_serializer(Landlord) -> dict:
    return {
        "id": str(Landlord["_id"]),
        "phone": Landlord["phone"],
        "fcm": Landlord["fcm"],
        "address": Landlord["address"],
        "uid": Landlord["uid"]
    }

def landlords_serializer(Landlords) -> list:
    return [landlord_serializer(Landlord) for Landlord in Landlords]