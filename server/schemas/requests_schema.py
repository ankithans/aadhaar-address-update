def request_serializer(Request) -> dict:
    return {
        "id": str(Request["_id"]),
        "tenant_id": Request["tenant_id"],
        "landlord_id": Request["landlord_id"],
        "status": Request["status"],
        "landlord_address": Request["landlord_address"],
        "created": Request["created"],
        "relation": Request["relation"],
        "reason": Request["reason"],
        "updated": Request["updated"]
    }

def requests_serializer(Requests) -> list:
    return [request_serializer(Request) for Request in Requests]