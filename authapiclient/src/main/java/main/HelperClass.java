package main;

import auth_2_0.*;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import com.sun.jersey.client.urlconnection.HTTPSProperties;
import constants.Constants;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.lang.StringUtils;
import org.bouncycastle.crypto.InvalidCipherTextException;
import org.bouncycastle.crypto.engines.AESEngine;
import org.bouncycastle.crypto.modes.GCMBlockCipher;
import org.bouncycastle.crypto.params.AEADParameters;
import org.bouncycastle.crypto.params.KeyParameter;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.exolab.castor.xml.*;
import org.exolab.castor.xml.util.ClassDescriptorResolverImpl;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import javax.crypto.*;
import javax.net.ssl.*;
import javax.xml.crypto.dsig.*;
import javax.xml.crypto.dsig.dom.DOMSignContext;
import javax.xml.crypto.dsig.keyinfo.KeyInfo;
import javax.xml.crypto.dsig.keyinfo.KeyInfoFactory;
import javax.xml.crypto.dsig.keyinfo.X509Data;
import javax.xml.crypto.dsig.spec.C14NMethodParameterSpec;
import javax.xml.crypto.dsig.spec.TransformParameterSpec;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.*;
import java.net.InetAddress;
import java.net.URI;
import java.net.URL;
import java.security.*;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.text.SimpleDateFormat;
import java.util.*;

public class HelperClass {


    public HelperClass(Properties configProp) {
        this.configProp = configProp;
    }

    private static ClassDescriptorResolver cdr = new ClassDescriptorResolverImpl();

    Properties configProp = new Properties();
    private KeyStore.PrivateKeyEntry keyEntry;
    public static X509Certificate publicKey;
    public static PublicKey pk;

    private static final String HASH_ALGORITHM_SHA_256 = "SHA-256";
    private static final String SKEY_ENCRYPTION_ALGORITHM = "RSA/ECB/PKCS1Padding";
    private static final String JCE_PROVIDER = "BC";
    private static final String MEC_TYPE = "DOM";
    private static final String WHOLE_DOC_URI = "";
    private static final String KEY_STORE_TYPE = "PKCS12";
    private static final int IV_SIZE = 12;
    private static final int AAD_SIZE = 16;
    private static final int AUTH_TAG_SIZE_BITS = 128;
    private static final String CERTIFICATE_TYPE = "X.509";





    public String createPid(String otpInRequest, Date timestamp, String mobile) throws MarshalException, ValidationException {
        Pid pid = new Pid();
        pid.setVer(configProp.getProperty(Constants.PID_VERSION));
        pid.setTs(timestamp);
        pid.setWadh("");

        Pv pv = new Pv();
        pv.setOtp(otpInRequest);
        pid.setPv(pv);
        if (mobile != null && !mobile.equals("")) {

            pid.setDemo(new Demo());
            pid.getDemo().setPi(new auth_2_0.Pi());
            pid.getDemo().getPi().setPhone(mobile);

        }
        StringWriter sw = new StringWriter();
        pid.marshal(sw);

        String pidXml = sw.toString();
        return pidXml;
    }

    public byte[] generateSessionKey() throws NoSuchProviderException, NoSuchAlgorithmException {
        KeyGenerator kgen = KeyGenerator.getInstance("AES", JCE_PROVIDER);
        kgen.init(256);
        SecretKey key = kgen.generateKey();
        return key.getEncoded();
    }


    public byte[] generateHash(String inputString) {
        byte[] hashValue;

        try {
            MessageDigest digest = MessageDigest.getInstance(HASH_ALGORITHM_SHA_256);
            hashValue = digest.digest(inputString.getBytes());
        } catch (Exception e) {
            throw new IllegalStateException("Auth XML; HMAC hash generation failed. ");
        }

        return hashValue;
    }

    public byte[] encrypt(byte[] plainTextBytes, byte[] encryptionKey, byte[] ivBytes)
            throws InvalidCipherTextException {
        return cipher(plainTextBytes, encryptionKey, ivBytes, true);
    }

    public byte[] encrypt(byte[] content, String publicKeyPath) throws NoSuchPaddingException, NoSuchAlgorithmException, NoSuchProviderException, InvalidKeyException, BadPaddingException, IllegalBlockSizeException {
        Cipher pkCipher = Cipher.getInstance(SKEY_ENCRYPTION_ALGORITHM, JCE_PROVIDER);
        pkCipher.init(Cipher.ENCRYPT_MODE, getpublicKey(publicKeyPath)); // localCertificate.getPublicKey().getPublicKey());
        // pkCipher.init(Cipher.ENCRYPT_MODE, ApplicationProperties.pk);

        return pkCipher.doFinal(content);
    }

    private byte[] cipher(byte[] sourceContent, byte[] secureKey, byte[] ivBytes, boolean encryptOperation) throws InvalidCipherTextException {

        int ivLength = ivBytes.length;

        // last IV_SIZE bytes
        byte[] iv = ArrayUtils.subarray(ivBytes, ivLength - IV_SIZE, ivLength);

        // last AAD_SIZE bytes
        byte[] aad = ArrayUtils.subarray(ivBytes, ivLength - AAD_SIZE, ivLength);

        AEADParameters aeadParam = new AEADParameters(new KeyParameter(secureKey), AUTH_TAG_SIZE_BITS, iv, aad);
        GCMBlockCipher gcmb = new GCMBlockCipher(new AESEngine());
        gcmb.init(encryptOperation, aeadParam);
        int outputSize = gcmb.getOutputSize(sourceContent.length);

        byte[] result = new byte[outputSize];
        int processLen = gcmb.processBytes(sourceContent, 0, sourceContent.length, result, 0);
        gcmb.doFinal(result, processLen);

        return result;

    }

    public AuthResponseDetailsV2 getAuthResponseDetailsV2(Auth auth) throws Exception {
        URI authServerURI = new URL(configProp.getProperty(Constants.AUTH_REQ_URL)).toURI();
        String signedXML = generateSignedAuthXML(auth);
        // _log.info(signedXML);

        String uriString;
        if (auth.getUid().length() < 16) {
            uriString = authServerURI.toString() + (authServerURI.toString().endsWith("/") ? "" : "/")
                    + auth.getAc() + "/" + auth.getUid().charAt(0) + "/" + auth.getUid().charAt(1);
        } else {
            uriString = authServerURI.toString() + (authServerURI.toString().endsWith("/") ? "" : "/")
                    + auth.getAc() + "/" + "0" + "/" + "0";
        }

        if (StringUtils.isNotBlank(configProp.getProperty(Constants.AUTH_REQ_ASA_LK))) {
            uriString = uriString + "/" + configProp.getProperty(Constants.AUTH_REQ_ASA_LK);
        }

        URI authServiceURI = new URI(uriString);

        WebResource webResource = Client.create(getClientConfig(authServerURI.getScheme()))
                .resource(authServiceURI);

        String responseXML = webResource.header("REMOTE_ADDR", InetAddress.getLocalHost().getHostAddress())
                .post(String.class, signedXML);


        return new AuthResponseDetailsV2(responseXML, parseAuthResponseXML(responseXML));

    }

    private  ClientConfig getClientConfig(String uriScheme) {
        ClientConfig config = new DefaultClientConfig();

        if (uriScheme.equalsIgnoreCase("https")) {
            X509TrustManager xtm = new X509TrustManager() {


                public void checkClientTrusted(X509Certificate[] arg0, String arg1) throws CertificateException {
                    return;
                }


                public void checkServerTrusted(X509Certificate[] arg0, String arg1) throws CertificateException {
                    return;
                }

                public X509Certificate[] getAcceptedIssuers() {
                    return null;
                }
            };
            TrustManager mytm[] = { xtm };

            HostnameVerifier hv = new HostnameVerifier() {

                public boolean verify(String hostname, SSLSession sslSession) {
                    return true;
                }
            };

            SSLContext ctx = null;

            try {
                ctx = SSLContext.getInstance("SSL");
                ctx.init(null, mytm, null);
                ((DefaultClientConfig) config).getProperties().put(HTTPSProperties.PROPERTY_HTTPS_PROPERTIES, new HTTPSProperties(hv, ctx));
            } catch (NoSuchAlgorithmException e) {
                e.printStackTrace();
            } catch (KeyManagementException e) {
                e.printStackTrace();
            }
        }

        return config;
    }


    public String generateSignedAuthXML(Auth auth) throws MarshalException, ValidationException, SAXException, javax.xml.crypto.MarshalException, NoSuchAlgorithmException, IOException, XMLSignatureException, ParserConfigurationException, InvalidAlgorithmParameterException, TransformerException {
        StringWriter authXML = new StringWriter();
        auth.marshal(authXML);

        boolean includeKeyInfo = true;

        if (System.getenv().get("SKIP_DIGITAL_SIGNATURE") != null) {
            return authXML.toString();
        } else {
            return signXML(authXML.toString(), includeKeyInfo);
        }
    }

    private KeyStore.PrivateKeyEntry getKeyEntry(){
        if(this.keyEntry == null){
            this.keyEntry = getKeyFromKeyStore();
        }

        if (this.keyEntry == null) {
            throw new RuntimeException("Key could not be read for digital signature. Please check value of signature "
                    + "alias and signature password, and restart the Auth Client");
        }
        return this.keyEntry;
    }

    public String signXML(String xmlDocument, boolean includeKeyInfo) throws ParserConfigurationException, IOException, SAXException, NoSuchAlgorithmException, XMLSignatureException, InvalidAlgorithmParameterException, javax.xml.crypto.MarshalException, TransformerException {
        Security.addProvider(new BouncyCastleProvider());
        // Parse the input XML
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        dbf.setNamespaceAware(true);
        Document inputDocument = dbf.newDocumentBuilder().parse(new InputSource(new StringReader(xmlDocument)));

        // Sign the input XML's DOM document
        Document signedDocument = sign(inputDocument, includeKeyInfo);

        // Convert the signedDocument to XML String
        StringWriter stringWriter = new StringWriter();
        TransformerFactory tf = TransformerFactory.newInstance();
        Transformer trans = tf.newTransformer();
        trans.transform(new DOMSource(signedDocument), new StreamResult(stringWriter));

        return stringWriter.getBuffer().toString();
    }

    private Document sign(Document xmlDoc, boolean includeKeyInfo) throws InvalidAlgorithmParameterException, NoSuchAlgorithmException, javax.xml.crypto.MarshalException, XMLSignatureException {

        if (System.getenv("SKIP_DIGITAL_SIGNATURE") != null) {
            return xmlDoc;
        }

        // Creating the XMLSignature factory.
        XMLSignatureFactory fac = XMLSignatureFactory.getInstance(MEC_TYPE);
        // Creating the reference object, reading the whole document for
        // signing.
        Reference ref = fac.newReference(WHOLE_DOC_URI, fac.newDigestMethod(DigestMethod.SHA1, null),
                Collections.singletonList(fac.newTransform(Transform.ENVELOPED, (TransformParameterSpec) null)), null,
                null);

        // Create the SignedInfo.
        SignedInfo sInfo = fac.newSignedInfo(
                fac.newCanonicalizationMethod(CanonicalizationMethod.INCLUSIVE, (C14NMethodParameterSpec) null),
                fac.newSignatureMethod(SignatureMethod.RSA_SHA1, null), Collections.singletonList(ref));

        X509Certificate x509Cert = (X509Certificate) getKeyEntry().getCertificate();

        KeyInfo kInfo = getKeyInfo(x509Cert, fac);
        DOMSignContext dsc = new DOMSignContext(getKeyEntry().getPrivateKey(), xmlDoc.getDocumentElement());
        XMLSignature signature = fac.newXMLSignature(sInfo, includeKeyInfo ? kInfo : null);
        signature.sign(dsc);

        Node node = dsc.getParent();
        return node.getOwnerDocument();

    }

    @SuppressWarnings("unchecked")
    private KeyInfo getKeyInfo(X509Certificate cert, XMLSignatureFactory fac) {
        // Create the KeyInfo containing the X509Data.
        KeyInfoFactory kif = fac.getKeyInfoFactory();
        List x509Content = new ArrayList();
        x509Content.add(cert.getSubjectX500Principal().getName());
        x509Content.add(cert);
        X509Data xd = kif.newX509Data(x509Content);
        return kif.newKeyInfo(Collections.singletonList(xd));
    }

    private KeyStore.PrivateKeyEntry getKeyFromKeyStore() {
        // Load the KeyStore and get the signing key and certificate.
        FileInputStream keyFileStream = null;
        try {
            KeyStore ks = KeyStore.getInstance(KEY_STORE_TYPE);
            keyFileStream = new FileInputStream(configProp.getProperty(Constants.AUTH_REQ_DIG_SIG_FILE));
            ks.load(keyFileStream, configProp.getProperty(Constants.AUTH_REQ_DIG_SIG_PASSWORD).toCharArray());

            KeyStore.PrivateKeyEntry entry = (KeyStore.PrivateKeyEntry) ks.getEntry(configProp.getProperty(Constants.AUTH_REQ_DIG_SIG_KEY_ALIAS),
                    new KeyStore.PasswordProtection(configProp.getProperty(Constants.AUTH_REQ_DIG_SIG_PASSWORD).toCharArray()));
            return entry;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            if (keyFileStream != null) {
                try {
                    keyFileStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    public AuthRes parseAuthResponseXML(String xmlToParse) throws MarshalException, ValidationException, IOException {

        AuthRes res = (AuthRes) parse(xmlToParse, AuthRes.class, false, true);
        return res;

    }


    @SuppressWarnings({ "unchecked", "rawtypes" })
    private static Object parse(String xml, Class targetClass,
                               boolean isValidationRequired, boolean ignoreExtraElements) throws IOException, MarshalException, ValidationException {

        Unmarshaller unmarshaller = new Unmarshaller(targetClass);
        unmarshaller.setIgnoreExtraElements(ignoreExtraElements);
        unmarshaller.setValidation(isValidationRequired);
        unmarshaller.setResolver(cdr);
        return unmarshaller.unmarshal(new StringReader(xml));
//        return transcoder.unmarshal(xml, targetClass, isValidationRequired,
//                ignoreExtraElements);
    }

    public static PublicKey getpublicKey(String publicKeyPath) {
        InputStream stream = null;

        try {

            stream = FileUtils.openInputStream(new File(publicKeyPath));
            CertificateFactory certFactory = CertificateFactory.getInstance(CERTIFICATE_TYPE, JCE_PROVIDER);
            publicKey = (X509Certificate) certFactory.generateCertificate(stream);
            pk = publicKey.getPublicKey();
            return pk;

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            IOUtils.closeQuietly(stream);
        }
        // return certificateIdentifier;
        return pk;

    }

    public static String getCI() {

        String certificateIdentifier = "";
        try {

            SimpleDateFormat ciDateFormat = new SimpleDateFormat("yyyyMMdd");
            ciDateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
            certificateIdentifier = ciDateFormat.format(publicKey.getNotAfter());
            return certificateIdentifier;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return certificateIdentifier;

    }




}
