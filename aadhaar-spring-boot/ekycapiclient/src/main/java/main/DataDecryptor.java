/**
 * DISCLAIMER: The sample code or utility or tool described herein
 * is provided on an "as is" basis, without warranty of any kind.
 * UIDAI does not warrant or guarantee the individual success
 * developers may have in implementing the sample code on their
 * environment. 
 * 
 * UIDAI does not warrant, guarantee or make any representations
 * of any kind with respect to the sample code and does not make
 * any representations or warranties regarding the use, results
 * of use, accuracy, timeliness or completeness of any data or
 * information relating to the sample code. UIDAI disclaims all
 * warranties, express or implied, and in particular, disclaims
 * all warranties of merchantability, fitness for a particular
 * purpose, and warranties related to the code, or any service
 * or software related thereto. 
 * 
 * UIDAI is not responsible for and shall not be liable directly
 * or indirectly for any direct, indirect damages or costs of any
 * type arising out of use or any action taken by you or others
 * related to the sample code.
 * 
 * THIS IS NOT A SUPPORTED SOFTWARE.
 * 
 */

package main;

import constants.Constants;
import org.bouncycastle.crypto.BufferedBlockCipher;
import org.bouncycastle.crypto.InvalidCipherTextException;
import org.bouncycastle.crypto.engines.AESEngine;
import org.bouncycastle.crypto.modes.CFBBlockCipher;
import org.bouncycastle.crypto.params.KeyParameter;
import org.bouncycastle.crypto.params.ParametersWithIV;
import org.bouncycastle.jce.provider.BouncyCastleProvider;

import javax.crypto.Cipher;
import javax.crypto.spec.OAEPParameterSpec;
import javax.crypto.spec.PSource;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.*;
import java.security.spec.MGF1ParameterSpec;
import java.util.Base64;
import java.util.Properties;


public class DataDecryptor {

	private static final int PUBLIC_KEY_SIZE = 294;
	private static final int EID_SIZE = 32;
	private static final int SECRET_KEY_SIZE = 256;
	private static final String TRANSFORMATION = "RSA/ECB/OAEPWITHSHA-256ANDMGF1PADDING";
	private static final String SECURITY_PROVIDER = "BC";
	private static final String DIGEST_ALGORITHM = "SHA-256";
	private static final String MASKING_FUNCTION = "MGF1";
	private static final int VECTOR_SIZE = 16;
	private static final int HMAC_SIZE = 32;
	private static final int BLOCK_SIZE = 128;
	private static final byte[] HEADER_DATA = "VERSION_1.0".getBytes();

	private KeyStore.PrivateKeyEntry privateKey;
	static{
	Security.addProvider(new BouncyCastleProvider());
	}
	Properties configProp = new Properties();


	public DataDecryptor() throws IOException {
		InputStream in = this.getClass().getClassLoader().getResourceAsStream("application.properties");
		configProp.load(in);
		this.privateKey = getKeyFromFile(configProp.getProperty(Constants.AUTH_REQ_DIG_SIG_FILE), configProp.getProperty(Constants.AUTH_REQ_DIG_SIG_PASSWORD).toCharArray());
		if (privateKey == null) {
			throw new RuntimeException("Key could not be read for digital signature. Please check value of signature "
					+ "alias and signature password, and restart the Auth Client");
		}

	}
	
	public byte[] decrypt(byte[] data) throws Exception {
		if(data == null || data.length == 0)
			throw new Exception("byte array data can not be null or blank array.");
		
		
		ByteArraySpliter arrSpliter = new ByteArraySpliter(data);
		
		byte[] secretKey = decryptSecretKeyData(arrSpliter.getEncryptedSecretKey(), arrSpliter.getIv(), privateKey.getPrivateKey());
		
		byte[] plainData = decryptData(arrSpliter.getEncryptedData(), arrSpliter.getIv(), secretKey);
		
		boolean result = validateHash(plainData);
		if(!result) 
			throw new Exception( "Integrity Validation Failed : " +
					"The original data at client side and the decrypted data at server side is not identical");
		
		return trimHMAC(plainData);
	}

	private KeyStore.PrivateKeyEntry getKeyFromFile(String keyStoreFile, char[] keyStorePassword) {

		try {
			// Load the KeyStore and get the signing key and certificate.
			KeyStore ks = KeyStore.getInstance("PKCS12");
			FileInputStream keyFileStream = new FileInputStream(keyStoreFile);
			ks.load(keyFileStream, keyStorePassword);

			KeyStore.PrivateKeyEntry  entry = (KeyStore.PrivateKeyEntry) ks.getEntry
					(configProp.getProperty(Constants.AUTH_REQ_DIG_SIG_KEY_ALIAS), new KeyStore.PasswordProtection(keyStorePassword));

			if(entry == null)
				throw new Exception("Key not found for the given alias.");

			keyFileStream.close();

			return entry;
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	
	private byte[] decryptSecretKeyData(byte[] encryptedSecretKey, byte[] iv, PrivateKey privateKey) throws Exception {
		
		try {
			Cipher rsaCipher = Cipher.getInstance(TRANSFORMATION, SECURITY_PROVIDER);

			PSource pSrc = (new PSource.PSpecified(iv));

			rsaCipher.init(Cipher.DECRYPT_MODE, privateKey,
					new OAEPParameterSpec(DIGEST_ALGORITHM, MASKING_FUNCTION,
							MGF1ParameterSpec.SHA256, pSrc));
			
			return rsaCipher.doFinal(encryptedSecretKey);
		} catch (GeneralSecurityException e) {
			e.printStackTrace();
			throw new Exception("Failed to decrypt AES secret key using RSA.", e);
		}
	}
	
	private byte[] decryptData(byte[] encryptedData, byte[] eid, byte[] secretKey) throws Exception {
		try {
			byte[][] iv = split(eid, VECTOR_SIZE);
			
			BufferedBlockCipher cipher = new BufferedBlockCipher(new CFBBlockCipher(new AESEngine(), BLOCK_SIZE));
			KeyParameter key = new KeyParameter(secretKey);
			
			cipher.init(false, new ParametersWithIV(key, iv[0]));
			
			int outputSize = cipher.getOutputSize(encryptedData.length);
			
			byte[] result = new byte[outputSize];
			int processLen = cipher.processBytes( encryptedData, 0, encryptedData.length, result, 0);
			cipher.doFinal(result, processLen);
			return result;
		}
		catch(InvalidCipherTextException txtExp) {
			throw new Exception("Decrypting data using AES failed", txtExp);
		}
	}
	
	private boolean validateHash(byte[] decryptedText) throws Exception {
		byte[][] hs = split(decryptedText, HMAC_SIZE);
		try {
			byte[] actualHash = generateHash(hs[1]);
			if (new String(hs[0], "UTF-8").equals(new String(actualHash, "UTF-8"))) {
				return true;
			} else {
				return false;
			}
		} 
		catch(Exception he) {
			throw new Exception("Not able to compute hash.", he);
		}
	}
	
	private byte[] trimHMAC(byte[] decryptedText) {
		byte[] actualText;
		if (decryptedText == null || decryptedText.length <= HMAC_SIZE) {
			actualText = new byte[0];
		} else {
			actualText = new byte[decryptedText.length - HMAC_SIZE];
			System.arraycopy(decryptedText, HMAC_SIZE, actualText, 0,
					actualText.length);
		}
		return actualText;
	}
	
	private static class ByteArraySpliter {
		
		private final byte[] headerVersion;
		private final byte[] iv; 
		private final byte[] encryptedSecretKey;
		private final byte[] encryptedData;
		private final byte[] publicKeyData;

		public ByteArraySpliter(byte[] data) throws Exception {
			int offset = 0;
			headerVersion = new byte[HEADER_DATA.length];
			copyByteArray(data, 0, headerVersion.length, headerVersion);
			offset = offset + HEADER_DATA.length;
			publicKeyData = new byte[PUBLIC_KEY_SIZE];
			copyByteArray(data, offset, publicKeyData.length, publicKeyData);
			offset = offset + PUBLIC_KEY_SIZE;
			iv = new byte[EID_SIZE];
			copyByteArray(data, offset, iv.length, iv);
			offset = offset + EID_SIZE;
			encryptedSecretKey = new byte[SECRET_KEY_SIZE];
			copyByteArray(data, offset, encryptedSecretKey.length, encryptedSecretKey);
			offset = offset + SECRET_KEY_SIZE;
			encryptedData = new byte[data.length - offset];
			copyByteArray(data, offset, encryptedData.length, encryptedData);
		}
		
		public byte[] getIv() {
			return iv;
		}

		public byte[] getEncryptedSecretKey() {
			return encryptedSecretKey;
		}

		public byte[] getEncryptedData() {
			return encryptedData;
		}

		private void copyByteArray(byte[] src, int offset, int length, byte[] dest) throws Exception {
			try {
				System.arraycopy(src, offset, dest, 0,length);
			}
			catch(Exception e) {
				
				throw new Exception("Decryption failed, Corrupted packet ", e);
			}
		}
	}
	
	private byte[][] split(byte[] src, int n) {
		byte[] l, r;
		if (src == null || src.length <= n) {
			l = src;
			r = new byte[0];
		} else {
			l = new byte[n];
			r = new byte[src.length - n];
			System.arraycopy(src, 0, l, 0, n);
			System.arraycopy(src, n, r, 0, r.length);
		}
		return new byte[][] { l, r };
	}
	
	public byte[] generateHash(byte[] message) throws Exception {
		byte[] hash = null;
		try {
			// Registering the Bouncy Castle as the RSA provider.
			MessageDigest digest = MessageDigest.getInstance(DIGEST_ALGORITHM, SECURITY_PROVIDER);
			digest.reset();
			hash = digest.digest(message);
		} catch (GeneralSecurityException e) {
			throw new Exception("SHA-256 Hashing algorithm not available");
		}
		return hash;
	}

}
