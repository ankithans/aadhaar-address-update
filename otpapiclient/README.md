## Client Application to simulate OTP Request API flow

### Introduction
This is a Spring boot application which can be used to generate OTP on the registered mobile number corresponding to the Staging UID.

#### Minimum Requirements
- Java 8
- Maven 3.6.1

### Steps to run

##### Clone the repo and resolve dependencies. Then, assign appropriate values to constants as follows-
- In application.properties
    - `signatureFile` - Change the path of 'PublicAUAforStagingServices.p12' file according to your local repository folder location. 

##### Run the application
- Flow starts from `OtpAPIClientMain.java` which takes Staging UID as input in commandline. 
- A random String (transaction Id) is also generated. You can use any transaction Id.
- The application will then create the signed OTP Request xml and makes call to OTP Request API.
- OTP Response xml (with same transaction Id as in request) will be parsed and result, error (if any) will get printed. 
- For a successful response, you will get an OTP on phone linked with staging UID. 


#### Contact
If you have any doubts around it, feel free to post those on [UIDAI hackathon forum](https://uidaiforum.cnihackathon.in/ "forum")
