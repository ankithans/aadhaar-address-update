import firebase_admin
from firebase_admin import credentials,messaging
from dotenv import load_dotenv
import os
import sys

load_dotenv()

dir = os.path.dirname(__file__)
filename = os.path.join(dir, "serviceaccountkey.json")
print(filename)
cred =credentials.Certificate(filename)
firebase_admin.initialize_app(cred)


def sendPush(title,msg,registration_token,dataObject=None):
    message=messaging.MulticastMessage(
        notification=messaging.Notification(
            title=title,
            body=msg
        ),
        data=dataObject,
        tokens=registration_token,
    )
    response=messaging.send_multicast(message)

    print("Successfully sent message:",response)