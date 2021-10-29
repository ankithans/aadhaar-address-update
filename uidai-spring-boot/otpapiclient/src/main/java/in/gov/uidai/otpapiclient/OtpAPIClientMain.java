package in.gov.uidai.otpapiclient;

import in.gov.uidai.otpapiclient.model.OtpRes;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Scanner;
import java.util.UUID;

@RestController
@SpringBootApplication
public class OtpAPIClientMain {

    @PostMapping(value="/otp/{uid}")
    public static OtpRes sendOTP(@PathVariable String uid) throws Exception {
        OtpAPIService otpAPIService = new OtpAPIService();
        otpAPIService.readProperties();
        String txnId = UUID.randomUUID().toString();
//        String txnId = "ankit";

        System.out.println("Printing txnId: " + txnId);
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter UID");
//        String uid = scanner.nextLine();
        OtpRes otpRes = otpAPIService.getOtpRes(uid,txnId);
        System.out.println("Result : " + otpRes.getRet().value() + ", err: " + otpRes.getErr());
        String r = "Result : " + otpRes.getRet().value() + ", err: " + otpRes.getErr();


        return otpRes;
    }



    public static void main(String[] args) throws Exception {
        SpringApplication.run(OtpAPIClientMain.class, args);
    }

}
