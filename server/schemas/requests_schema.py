def request_serializer(Request) -> dict:
    return {
        "id": str(Request["_id"]),
        "tenant_uid": Request["tenant_uid"],
        "landlord_uid": Request["landlord_uid"],
        "landlord_no": Request["landlord_no"],
        "status": Request["status"],
        "landlord_address": Request["landlord_address"],
        "created": Request["created"],
        "relation": Request["relation"],
        "reason": Request["reason"],
        "updated": Request["updated"]
    }

def requests_serializer(Requests) -> list:
    return [request_serializer(Request) for Request in Requests]