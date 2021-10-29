## Client Application to test Auth API for OTP verification.

### Introduction
Aadhaar “authentication” means the process wherein Aadhaar Number or Virtual ID or
UID Token, along with other attributes, including biometrics and OTP, are submitted to the
Central Identities Data Repository (CIDR) for its verification on the basis of information
or data or documents available with it. UIDAI provides an online service to support this
process. Aadhaar authentication service only responds with a “yes/no” and no personal
identity information is returned as part of the response.

Auth-client provides an interface  to  interact  with  the  Auth  API of UIDAI. After getting OTP on the basis of
UID/VID on your registered mobile number, this test client makes a call to Auth API to verify the OTP.


#### Minimum Requirements
- Java 11
- Maven 3.6.1

### Steps to run

##### Clone the repo and resolve dependencies. Then, assign appropriate values to constants as follows-
- In application.properties
    - `authReqDigSigFile` and `authReqPubKeyFile` - Change the path of 'PublicAUAforStagingServices.p12' and 'AuthStaging25082025.cer' file according to your local repository folder location.

##### Run the application
Flow starts from Main.java.
The following are needed to be provided in arguments:

1. UID/VID
2. Txn code of OTP
3. OTP

After successful verification, "y" will be printed on console, otherwise, on "n" will be printed along with the error code.
Refer Auth documentation available on Hackathon portal to find detailed description of request and response structure of Auth API.


#### Contact
If you have any doubts around it, feel free to post those on [UIDAI hackathon forum](https://uidaiforum.cnihackathon.in/ "forum")
