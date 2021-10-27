package main;

import auth_2_0.Auth;
import auth_2_0.AuthRes;
import constants.Constants;
import auth_2_0.AuthResponseDetailsV2;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.bouncycastle.crypto.InvalidCipherTextException;
import org.exolab.castor.xml.MarshalException;
import org.exolab.castor.xml.ValidationException;
import org.springframework.boot.SpringApplication;
//import org.springframework.core.metrics.ApplicationStartup;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

import main.HelperClass;


@RestController
@SpringBootApplication
public class Main {

    @RequestMapping(value="/auth")
    public static String checkAuth() throws Exception {
        HelperClass helperClass = new HelperClass(OTPAuth.configProp);
        String uid = "args[0]";
        String txn = "args[1]";
        String optRequest = "args[2]";
        System.out.println("UID: " + uid + " TxnId: " + txn + " OTP :" + optRequest);
        OTPAuth otpAuth = new OTPAuth();
        Auth authObj = otpAuth.createResidentAuth(uid, txn, optRequest, new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss").format(new Date()), "");
        AuthResponseDetailsV2 data = helperClass.getAuthResponseDetailsV2(authObj);

        // Get Auth Response
        AuthRes authRes = data.getAuthRes();
        return "Auth Response: " + authRes.getRet().toString();
//        if (authRes.getErr() != null)
//            return "ErrorCode: " + authRes.getErr();
    }

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }

}

//public class Main {
//    public static void main(String[] args) {
//        OTPAuth OTPAuth = new OTPAuth();
//        try {
//            OTPAuth.readProperties();
//            HelperClass helperClass = new HelperClass(OTPAuth.configProp);
//
//            String uid = args[0];
//            String txn = args[1];
//            String optRequest = args[2];
//            System.out.println("UID: "+uid+" TxnId: "+txn+" OTP :"+optRequest);
//            Auth auth = OTPAuth.createResidentAuth(uid, txn, optRequest, new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss").format(new Date()), "");
//            AuthResponseDetailsV2 data = helperClass.getAuthResponseDetailsV2(auth);
//
//            // Get Auth Response
//            AuthRes authRes = data.getAuthRes();
//            System.out.println("Auth Response: " + authRes.getRet().toString());
//            if (authRes.getErr() != null)
//            System.out.println("ErrorCode: "+authRes.getErr());
//            System.out.println(authRes);
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }




//}


//public class Main extends HttpServlet {
//
//    public static void main(String[] args) {
//
//    }
//
//    @Override
//    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
//
//        String requestUrl = request.getRequestURI();
//        String name = requestUrl.substring("/auth/".length());
//
//        OTPAuth OTPAuth = new OTPAuth();
//        try {
//            OTPAuth.readProperties();
//            HelperClass helperClass = new HelperClass(OTPAuth.configProp);
//
//            String uid = "";
//            String txn = "";
//            String optRequest = "";
//            System.out.println("UID: "+uid+" TxnId: "+txn+" OTP :"+optRequest);
//            Auth auth = OTPAuth.createResidentAuth(uid, txn, optRequest, new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss").format(new Date()), "");
//            AuthResponseDetailsV2 data = helperClass.getAuthResponseDetailsV2(auth);
//
//            // Get Auth Response
//            AuthRes authRes = data.getAuthRes();
//            System.out.println("Auth Response: " + authRes.getRet().toString());
//            if (authRes.getErr() != null)
//            System.out.println("ErrorCode: "+authRes.getErr());
//            System.out.println(authRes);
//
////            String json = "{\n";
////            json += "\"name\": " + JSONObject.quote(person.getName()) + ",\n";
////            json += "\"about\": " + JSONObject.quote(person.getAbout()) + ",\n";
////            json += "\"birthYear\": " + person.getBirthYear() + "\n";
////            json += "}";
//            String json = JSONObject.quote(authRes.getRet().toString());
//            response.getOutputStream().println(json);
//
//        } catch (Exception e) {
//            e.printStackTrace();
//            response.getOutputStream().println("{}");
//
//        }
//    }
//
//
//
////    @Override
////    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
////
////        String name = request.getParameter("name");
////        String about = request.getParameter("about");
////        int birthYear = Integer.parseInt(request.getParameter("birthYear"));
////
////        DataStore.getInstance().putPerson(new Person(name, about, birthYear, password));
////    }
//}