def landlord_serializer(Landlord) -> dict:
    return {
        "id": str(Landlord["_id"]),
        "name": Landlord["name"],
        "description": Landlord["description"],
        "completed": Landlord["completed"],
        "date": Landlord["date"],
    }

def landlords_serializer(Landlords) -> list:
    return [landlord_serializer(Landlord) for Landlord in Landlords]