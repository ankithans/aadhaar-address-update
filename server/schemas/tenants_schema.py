def tenant_serializer(Tenant) -> dict:
    return {
        "id": str(Tenant["_id"]),
        "phone": Tenant["phone"],
        "fcm": Tenant["fcm"],
        "address": Tenant["address"]
    }

def tenants_serializer(Tenants) -> list:
    return [tenant_serializer(Tenant) for Tenant in Tenants]