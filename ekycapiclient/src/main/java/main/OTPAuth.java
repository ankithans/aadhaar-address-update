package main;

import auth_2_0.*;
import auth_2_0.types.AuthRcType;
import auth_2_0.types.DataFormat;
import auth_2_0.types.UsesType;
import constants.Constants;
import org.apache.commons.lang.ArrayUtils;
import org.bouncycastle.crypto.InvalidCipherTextException;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.exolab.castor.xml.ValidationException;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringWriter;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.Security;
import java.util.Date;
import java.util.Properties;

public class OTPAuth {

    public Constants constants = new Constants();
    HelperClass helperClass;

    Properties configProp = new Properties();

    public void readProperties(HelperClass helperClass) throws IOException {
        InputStream in = this.getClass().getClassLoader().getResourceAsStream("application.properties");
        configProp.load(in);
        this.helperClass = helperClass;
    }


    public Auth createResidentAuth(String uid, String txn, String otpInRequest, String timeStamp, String mobile) throws ValidationException, NoSuchProviderException, NoSuchAlgorithmException, InvalidCipherTextException, IllegalBlockSizeException, InvalidKeyException, BadPaddingException, NoSuchPaddingException, org.exolab.castor.xml.MarshalException {
        Security.addProvider(new BouncyCastleProvider()); // added
        Auth auth = new Auth();

        auth.setVer(configProp.getProperty(Constants.AUTH_REQ_VERSION));
        auth.setRc(AuthRcType.Y);
        auth.setAc(configProp.getProperty(Constants.AUTH_REQ_AUA));
        auth.setLk(configProp.getProperty(Constants.AUTH_REQ_AUA_LK));
        auth.setSa(configProp.getProperty(Constants.AUTH_REQUEST_ASA));
        auth.setTid("");
        auth.setTxn(txn);
        auth.setUid(uid);

        // pid
        Date pidDate = new Date();
        String pidXml = helperClass.createPid(otpInRequest, pidDate, mobile);
        byte[] sessionKey = helperClass.generateSessionKey();
        helperClass.saveSkey(sessionKey);

        // hmac
        byte[] hmac = helperClass.generateHash(pidXml);
        byte[] encryptedHmac = helperClass.encrypt(hmac, sessionKey, timeStamp.getBytes());
        auth.setHmac(encryptedHmac);

        // uses
        Uses uses = new Uses();
        uses.setBio(UsesType.N);
        uses.setOtp(UsesType.Y);
        uses.setPa(UsesType.N);
        uses.setPfa(UsesType.N);
        if (mobile != null && !mobile.equals("")) {
            uses.setPi(UsesType.Y);
        } else {
            uses.setPi(UsesType.N);
        }
        uses.setPin(UsesType.N);
        uses.setBt("");
        auth.setUses(uses);

        // meta
        Meta meta = new Meta();
        meta.setDc("");
        meta.setDpId("");
        meta.setMc("");
        meta.setMi("");
        meta.setRdsId("");
        meta.setRdsVer("");
        /* meta.setUdc("VIDGeneration"); */
        auth.setMeta(meta);

        // s key
        Skey skey = new Skey();
        skey.setContent(helperClass.encrypt(sessionKey, configProp.getProperty(Constants.AUTH_REQ_PUB_KEY_FILE)));
        skey.setCi(helperClass.getCI());
        auth.setSkey(skey);

        // data
        Data data = new Data();
        data.setType(DataFormat.X);
        byte[] encryptedBytes = helperClass.encrypt(pidXml.getBytes(), sessionKey, timeStamp.getBytes());
        helperClass.saveIvBytes(timeStamp);
        byte[] encryptedPid = ArrayUtils.addAll(timeStamp.getBytes(), encryptedBytes);
        data.setContent(encryptedPid);
        auth.setData(data);

        StringWriter sw1 = new StringWriter();
        auth.marshal(sw1);
        return auth;
    }

}

