from fastapi import APIRouter, HTTPException
from datetime import datetime
from ..schemas.auditlog_schema import auditlogs_serializer
from ..config.database import db

    # datetime

    # Tenant()/ landlord logged in as tenant

    # Tenant() created request () to landlord ()

    #Landlord() approved/denied requestid

    #Tenant() 

    # Status : succusful

def pushAudit(status,description):
    audit = {
        "datetime": datetime.today() ,
        "status":status,
        "description":description
    }
    db["auditlogs"].insert_one(audit)