def tenant_serializer(Landlord) -> dict:
    return {
        "id": str(Landlord["_id"]),
        "phone": Landlord["phone"],
        "fcm": Landlord["fcm"],
        "address": Landlord["address"]
    }

def tenants_serializer(Tenants) -> list:
    return [tenant_serializer(Tenant) for Tenant in Tenants]