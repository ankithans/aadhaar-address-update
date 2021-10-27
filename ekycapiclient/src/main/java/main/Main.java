package main;

import auth_2_0.Auth;
import ekyc.response.Resp;
import org.json.JSONObject;
import org.json.XML;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import java.io.IOException;
import java.io.StringReader;
import java.text.SimpleDateFormat;
import java.util.Base64;
import java.util.Date;

@RestController
@SpringBootApplication
public class Main {

    @PostMapping(value="/ekyc/{uid}/{txn1}/{optRequest}")
    public static Object ekycReq(@PathVariable String uid, @PathVariable String txn1, @PathVariable String optRequest) throws Exception {
        OTPAuth OTPAuth = new OTPAuth();
        EKYCService ekycService = new EKYCService();
        try {
            HelperClass helperClass = new HelperClass(OTPAuth.configProp);
            OTPAuth.readProperties(helperClass);

//            String uid = args[0];
            String txn = "UKC:"+txn1;
//            String optRequest = args[2];
            System.out.println("UID: "+uid+" TxnId: "+txn+" OTP :"+optRequest);
            Auth auth = OTPAuth.createResidentAuth(uid, txn, optRequest, new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss").format(new Date()), "");
            String signedXml = helperClass.getSignedXml(auth);
            String rad = Base64.getEncoder().encodeToString(signedXml.getBytes());
            String ekycResponse = ekycService.getEkycResponse(uid, rad);

            JAXBContext jaxbContext = JAXBContext.newInstance(Resp.class);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            Resp resp = (Resp) unmarshaller.unmarshal(new StringReader(ekycResponse));
            System.out.println(" KYC Response with status : " + resp.getRet());
            if(resp.getRet().equalsIgnoreCase("N")){
                System.out.println("Error code: " + resp.getErr());
                System.out.println("***************************************");

                System.out.println(ekycResponse);

                return ekycResponse;

            }else {
                byte[] encryptedString = Base64.getDecoder().decode(resp.getKycRes());

                DataDecryptor dataDecryptor = new DataDecryptor();
                byte[] decryptedKycResp = dataDecryptor.decrypt(encryptedString);
                System.out.println("************* Decrypted ekyc response ***********");

                System.out.println(new String(decryptedKycResp));
//                JSONObject json = XML.toJSONObject(String.valueOf(dataDecryptor));
                return new String(decryptedKycResp);
            }
//        return "";

        } catch (Exception e) {
            e.printStackTrace();
            return e;
        }

//        return null;
    }


    public static void main(String[] args) throws IOException {
        SpringApplication.run(Main.class, args);
    }



}
