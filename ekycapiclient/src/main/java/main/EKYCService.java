package main;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import com.sun.jersey.client.urlconnection.HTTPSProperties;
import constants.Constants;
import org.apache.commons.lang.StringUtils;

import javax.net.ssl.*;
import java.io.IOException;
import java.io.InputStream;
import java.net.*;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.Properties;

public class EKYCService {

    Properties configProp = new Properties();

    public EKYCService() throws IOException {
        InputStream in = this.getClass().getClassLoader().getResourceAsStream("application.properties");
        configProp.load(in);
    }

    public String getEkycResponse(String uid, String rad) throws MalformedURLException, URISyntaxException, UnknownHostException {

        String ekycRequest = getEkycRequest( rad);

        String ekycResponse = getResponseFromServer(uid, ekycRequest);
        return ekycResponse;
    }

    private String getResponseFromServer(String uid, String ekycRequest) throws MalformedURLException, URISyntaxException, UnknownHostException {
        URI authServerURI = new URL(configProp.getProperty(Constants.EKYC_URL)).toURI();
        // _log.info(signedXML);

        String uriString;
        if (uid.length() < 16) {
            uriString = authServerURI.toString() + (authServerURI.toString().endsWith("/") ? "" : "/")
                    + configProp.getProperty(Constants.AUTH_REQ_AUA) + "/" + uid.charAt(0) + "/" + uid.charAt(1);
        } else {
            uriString = authServerURI.toString() + (authServerURI.toString().endsWith("/") ? "" : "/")
                    + configProp.getProperty(Constants.AUTH_REQ_AUA) + "/" + "0" + "/" + "0";
        }

        if (StringUtils.isNotBlank(configProp.getProperty(Constants.AUTH_REQ_ASA_LK))) {
            uriString = uriString + "/" + configProp.getProperty(Constants.AUTH_REQ_ASA_LK);
        }

        URI authServiceURI = new URI(uriString);

        WebResource webResource = Client.create(getClientConfig(authServerURI.getScheme()))
                .resource(authServiceURI);

        String responseXML = webResource.header("REMOTE_ADDR", InetAddress.getLocalHost().getHostAddress())
                .post(String.class, ekycRequest);
        return responseXML;
    }

    private ClientConfig getClientConfig(String uriScheme) {
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

    private String getEkycRequest(String signedXml) {
        return "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
                "<kyc de=\"N\" lr=\"N\" pfr=\"N\" ra=\"O\" rc=\"Y\" ver=\"2.5\">\n" +
                "    <Rad>"+signedXml+"</Rad>\n" +
                "</kyc>";
    }
}
