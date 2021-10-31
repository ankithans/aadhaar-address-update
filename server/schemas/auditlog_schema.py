def auditlog_serializer(auditlog) -> dict:
    return {
        "id": str(auditlog["_id"]),
        "datetime": auditlog["datetime"],
        "description": auditlog["description"],
        "status": auditlog["status"]
    }

def auditlogs_serializer(auditlogs) -> list:
    return [auditlog_serializer(auditlog) for auditlog in auditlogs]