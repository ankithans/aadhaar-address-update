package main;

import auth_2_0.Auth;
import auth_2_0.AuthRes;
import auth_2_0.AuthResponseDetailsV2;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.boot.SpringApplication;
//import org.springframework.core.metrics.ApplicationStartup;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@SpringBootApplication
public class Main {

    @PostMapping(value="/auth/{uid}/{txn}/{otpInRRequest}")
    public static Object checkAuth(@PathVariable String uid, @PathVariable String txn, @PathVariable String otpInRRequest) throws Exception {
        OTPAuth OTPAuth = new OTPAuth();
        try {
            OTPAuth.readProperties();
            HelperClass helperClass = new HelperClass(OTPAuth.configProp);


            System.out.println("UID: "+uid+" TxnId: "+txn+" OTP :"+otpInRRequest);
            Auth auth = OTPAuth.createResidentAuth(uid, txn, otpInRRequest, new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss").format(new Date()), "");
            AuthResponseDetailsV2 data = helperClass.getAuthResponseDetailsV2(auth);

            // Get Auth Response
            AuthRes authRes = data.getAuthRes();
            System.out.println("Auth Response: " + authRes.getRet().toString());
            if (authRes.getErr() != null)
                System.out.println("ErrorCode: "+authRes.getErr());

            return authRes;

        } catch (Exception e) {
            e.printStackTrace();
            return e;
        }
    }

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }

}