/*
 * This class was automatically generated with 
 * <a href="http://www.castor.org">Castor 0.9.7</a>, using an XML
 * Schema.
 * $Id$
 */

package auth_2_0.types;

  //---------------------------------/
 //- Imported classes and packages -/
//---------------------------------/

import java.io.Serializable;
import java.util.Enumeration;
import java.util.Hashtable;
import org.exolab.castor.xml.Marshaller;
import org.exolab.castor.xml.Unmarshaller;

/**
 * Enum providing additional meaning to those error
 *  codes which may have
 *  multiple meanings.
 *  
 * 
 * @version $Revision$ $Date$
 */
public class AuthErrorClassification implements Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * The UID_NOT_FOUND type
     */
    public static final int UID_NOT_FOUND_TYPE = 0;

    /**
     * The instance of the UID_NOT_FOUND type
     */
    public static final AuthErrorClassification UID_NOT_FOUND = new AuthErrorClassification(UID_NOT_FOUND_TYPE, "UID_NOT_FOUND");

    /**
     * The INVALID_UID_STATUS type
     */
    public static final int INVALID_UID_STATUS_TYPE = 1;

    /**
     * The instance of the INVALID_UID_STATUS type
     */
    public static final AuthErrorClassification INVALID_UID_STATUS = new AuthErrorClassification(INVALID_UID_STATUS_TYPE, "INVALID_UID_STATUS");

    /**
     * The INVALID_UID type
     */
    public static final int INVALID_UID_TYPE = 2;

    /**
     * The instance of the INVALID_UID type
     */
    public static final AuthErrorClassification INVALID_UID = new AuthErrorClassification(INVALID_UID_TYPE, "INVALID_UID");

    /**
     * The UID_INACTIVE type
     */
    public static final int UID_INACTIVE_TYPE = 3;

    /**
     * The instance of the UID_INACTIVE type
     */
    public static final AuthErrorClassification UID_INACTIVE = new AuthErrorClassification(UID_INACTIVE_TYPE, "UID_INACTIVE");

    /**
     * The UID_BLOCKED type
     */
    public static final int UID_BLOCKED_TYPE = 4;

    /**
     * The instance of the UID_BLOCKED type
     */
    public static final AuthErrorClassification UID_BLOCKED = new AuthErrorClassification(UID_BLOCKED_TYPE, "UID_BLOCKED");

    /**
     * The UID_DESEASED type
     */
    public static final int UID_DESEASED_TYPE = 5;

    /**
     * The instance of the UID_DESEASED type
     */
    public static final AuthErrorClassification UID_DESEASED = new AuthErrorClassification(UID_DESEASED_TYPE, "UID_DESEASED");

    /**
     * The UID_CANCELLED type
     */
    public static final int UID_CANCELLED_TYPE = 6;

    /**
     * The instance of the UID_CANCELLED type
     */
    public static final AuthErrorClassification UID_CANCELLED = new AuthErrorClassification(UID_CANCELLED_TYPE, "UID_CANCELLED");

    /**
     * The INCORRECT_PIN type
     */
    public static final int INCORRECT_PIN_TYPE = 7;

    /**
     * The instance of the INCORRECT_PIN type
     */
    public static final AuthErrorClassification INCORRECT_PIN = new AuthErrorClassification(INCORRECT_PIN_TYPE, "INCORRECT_PIN");

    /**
     * The INCORRECT_OTP type
     */
    public static final int INCORRECT_OTP_TYPE = 8;

    /**
     * The instance of the INCORRECT_OTP type
     */
    public static final AuthErrorClassification INCORRECT_OTP = new AuthErrorClassification(INCORRECT_OTP_TYPE, "INCORRECT_OTP");

    /**
     * The TKN_MISMATCH type
     */
    public static final int TKN_MISMATCH_TYPE = 9;

    /**
     * The instance of the TKN_MISMATCH type
     */
    public static final AuthErrorClassification TKN_MISMATCH = new AuthErrorClassification(TKN_MISMATCH_TYPE, "TKN_MISMATCH");

    /**
     * The FRAUD_CHECK_FAILED type
     */
    public static final int FRAUD_CHECK_FAILED_TYPE = 10;

    /**
     * The instance of the FRAUD_CHECK_FAILED type
     */
    public static final AuthErrorClassification FRAUD_CHECK_FAILED = new AuthErrorClassification(FRAUD_CHECK_FAILED_TYPE, "FRAUD_CHECK_FAILED");

    /**
     * The NO_BIOMETRIC_GALLERY type
     */
    public static final int NO_BIOMETRIC_GALLERY_TYPE = 11;

    /**
     * The instance of the NO_BIOMETRIC_GALLERY type
     */
    public static final AuthErrorClassification NO_BIOMETRIC_GALLERY = new AuthErrorClassification(NO_BIOMETRIC_GALLERY_TYPE, "NO_BIOMETRIC_GALLERY");

    /**
     * The TID_NOT_FOUND type
     */
    public static final int TID_NOT_FOUND_TYPE = 12;

    /**
     * The instance of the TID_NOT_FOUND type
     */
    public static final AuthErrorClassification TID_NOT_FOUND = new AuthErrorClassification(TID_NOT_FOUND_TYPE, "TID_NOT_FOUND");

    /**
     * The BIOMETRIC_LOCKED type
     */
    public static final int BIOMETRIC_LOCKED_TYPE = 13;

    /**
     * The instance of the BIOMETRIC_LOCKED type
     */
    public static final AuthErrorClassification BIOMETRIC_LOCKED = new AuthErrorClassification(BIOMETRIC_LOCKED_TYPE, "BIOMETRIC_LOCKED");

    /**
     * The BIOMETRIC_LOCK_RELATED_TECHNICAL_ERROR type
     */
    public static final int BIOMETRIC_LOCK_RELATED_TECHNICAL_ERROR_TYPE = 14;

    /**
     * The instance of the BIOMETRIC_LOCK_RELATED_TECHNICAL_ERROR
     * type
     */
    public static final AuthErrorClassification BIOMETRIC_LOCK_RELATED_TECHNICAL_ERROR = new AuthErrorClassification(BIOMETRIC_LOCK_RELATED_TECHNICAL_ERROR_TYPE, "BIOMETRIC_LOCK_RELATED_TECHNICAL_ERROR");

    /**
     * The AADHAAR_SUSPENDED_DUE_TO_INACTIVITY type
     */
    public static final int AADHAAR_SUSPENDED_DUE_TO_INACTIVITY_TYPE = 15;

    /**
     * The instance of the AADHAAR_SUSPENDED_DUE_TO_INACTIVITY type
     */
    public static final AuthErrorClassification AADHAAR_SUSPENDED_DUE_TO_INACTIVITY = new AuthErrorClassification(AADHAAR_SUSPENDED_DUE_TO_INACTIVITY_TYPE, "AADHAAR_SUSPENDED_DUE_TO_INACTIVITY");

    /**
     * The AADHAAR_CANCELED_DUE_TO_DUPLICATE type
     */
    public static final int AADHAAR_CANCELED_DUE_TO_DUPLICATE_TYPE = 16;

    /**
     * The instance of the AADHAAR_CANCELED_DUE_TO_DUPLICATE type
     */
    public static final AuthErrorClassification AADHAAR_CANCELED_DUE_TO_DUPLICATE = new AuthErrorClassification(AADHAAR_CANCELED_DUE_TO_DUPLICATE_TYPE, "AADHAAR_CANCELED_DUE_TO_DUPLICATE");

    /**
     * The AADHAAR_CANCELED_DUE_TO_FRUAD_ENROLMENTS type
     */
    public static final int AADHAAR_CANCELED_DUE_TO_FRUAD_ENROLMENTS_TYPE = 17;

    /**
     * The instance of the AADHAAR_CANCELED_DUE_TO_FRUAD_ENROLMENTS
     * type
     */
    public static final AuthErrorClassification AADHAAR_CANCELED_DUE_TO_FRUAD_ENROLMENTS = new AuthErrorClassification(AADHAAR_CANCELED_DUE_TO_FRUAD_ENROLMENTS_TYPE, "AADHAAR_CANCELED_DUE_TO_FRUAD_ENROLMENTS");

    /**
     * The AADHAAR_CANCELED_FOR_TEST_CASES_OR_TECHINICAL_ISSUES type
     */
    public static final int AADHAAR_CANCELED_FOR_TEST_CASES_OR_TECHINICAL_ISSUES_TYPE = 18;

    /**
     * The instance of the
     * AADHAAR_CANCELED_FOR_TEST_CASES_OR_TECHINICAL_ISSUES type
     */
    public static final AuthErrorClassification AADHAAR_CANCELED_FOR_TEST_CASES_OR_TECHINICAL_ISSUES = new AuthErrorClassification(AADHAAR_CANCELED_FOR_TEST_CASES_OR_TECHINICAL_ISSUES_TYPE, "AADHAAR_CANCELED_FOR_TEST_CASES_OR_TECHINICAL_ISSUES");

    /**
     * The AADHAAR_CANCELED_DUE_TO_BIOMETRIC_EXCEPTION_CASES type
     */
    public static final int AADHAAR_CANCELED_DUE_TO_BIOMETRIC_EXCEPTION_CASES_TYPE = 19;

    /**
     * The instance of the
     * AADHAAR_CANCELED_DUE_TO_BIOMETRIC_EXCEPTION_CASES type
     */
    public static final AuthErrorClassification AADHAAR_CANCELED_DUE_TO_BIOMETRIC_EXCEPTION_CASES = new AuthErrorClassification(AADHAAR_CANCELED_DUE_TO_BIOMETRIC_EXCEPTION_CASES_TYPE, "AADHAAR_CANCELED_DUE_TO_BIOMETRIC_EXCEPTION_CASES");

    /**
     * The AADHAAR_CANCELED_DUE_TO_COGENT_FLIP_IRIS_CASES type
     */
    public static final int AADHAAR_CANCELED_DUE_TO_COGENT_FLIP_IRIS_CASES_TYPE = 20;

    /**
     * The instance of the
     * AADHAAR_CANCELED_DUE_TO_COGENT_FLIP_IRIS_CASES type
     */
    public static final AuthErrorClassification AADHAAR_CANCELED_DUE_TO_COGENT_FLIP_IRIS_CASES = new AuthErrorClassification(AADHAAR_CANCELED_DUE_TO_COGENT_FLIP_IRIS_CASES_TYPE, "AADHAAR_CANCELED_DUE_TO_COGENT_FLIP_IRIS_CASES");

    /**
     * The AADHAAR_SUSPENDED_FOR_BIOMETRIC_UPDATE type
     */
    public static final int AADHAAR_SUSPENDED_FOR_BIOMETRIC_UPDATE_TYPE = 21;

    /**
     * The instance of the AADHAAR_SUSPENDED_FOR_BIOMETRIC_UPDATE
     * type
     */
    public static final AuthErrorClassification AADHAAR_SUSPENDED_FOR_BIOMETRIC_UPDATE = new AuthErrorClassification(AADHAAR_SUSPENDED_FOR_BIOMETRIC_UPDATE_TYPE, "AADHAAR_SUSPENDED_FOR_BIOMETRIC_UPDATE");

    /**
     * The AADHAAR_SUSPENDED_FOR_DEMOGRAPHIC_UPDATE type
     */
    public static final int AADHAAR_SUSPENDED_FOR_DEMOGRAPHIC_UPDATE_TYPE = 22;

    /**
     * The instance of the AADHAAR_SUSPENDED_FOR_DEMOGRAPHIC_UPDATE
     * type
     */
    public static final AuthErrorClassification AADHAAR_SUSPENDED_FOR_DEMOGRAPHIC_UPDATE = new AuthErrorClassification(AADHAAR_SUSPENDED_FOR_DEMOGRAPHIC_UPDATE_TYPE, "AADHAAR_SUSPENDED_FOR_DEMOGRAPHIC_UPDATE");

    /**
     * The
     * AADHAAR_SUSPENDED_BY_COMPETENT_AUTHORITY_DUE_TO_ADDRESS_DISPUTE
     * type
     */
    public static final int AADHAAR_SUSPENDED_BY_COMPETENT_AUTHORITY_DUE_TO_ADDRESS_DISPUTE_TYPE = 23;

    /**
     * The instance of the
     * AADHAAR_SUSPENDED_BY_COMPETENT_AUTHORITY_DUE_TO_ADDRESS_DISPUTE
     * type
     */
    public static final AuthErrorClassification AADHAAR_SUSPENDED_BY_COMPETENT_AUTHORITY_DUE_TO_ADDRESS_DISPUTE = new AuthErrorClassification(AADHAAR_SUSPENDED_BY_COMPETENT_AUTHORITY_DUE_TO_ADDRESS_DISPUTE_TYPE, "AADHAAR_SUSPENDED_BY_COMPETENT_AUTHORITY_DUE_TO_ADDRESS_DISPUTE");

    /**
     * The
     * AADHAAR_SUSPENDED_BY_COMPETENT_AUTHORITY_DUE_TO_PHOTO_DISPUTE
     * type
     */
    public static final int AADHAAR_SUSPENDED_BY_COMPETENT_AUTHORITY_DUE_TO_PHOTO_DISPUTE_TYPE = 24;

    /**
     * The instance of the
     * AADHAAR_SUSPENDED_BY_COMPETENT_AUTHORITY_DUE_TO_PHOTO_DISPUTE
     * type
     */
    public static final AuthErrorClassification AADHAAR_SUSPENDED_BY_COMPETENT_AUTHORITY_DUE_TO_PHOTO_DISPUTE = new AuthErrorClassification(AADHAAR_SUSPENDED_BY_COMPETENT_AUTHORITY_DUE_TO_PHOTO_DISPUTE_TYPE, "AADHAAR_SUSPENDED_BY_COMPETENT_AUTHORITY_DUE_TO_PHOTO_DISPUTE");

    /**
     * The
     * AADHAAR_SUSPENDED_BY_COMPETENT_AUTHORITY_DUE_TO_AGE_DISPUTE
     * type
     */
    public static final int AADHAAR_SUSPENDED_BY_COMPETENT_AUTHORITY_DUE_TO_AGE_DISPUTE_TYPE = 25;

    /**
     * The instance of the
     * AADHAAR_SUSPENDED_BY_COMPETENT_AUTHORITY_DUE_TO_AGE_DISPUTE
     * type
     */
    public static final AuthErrorClassification AADHAAR_SUSPENDED_BY_COMPETENT_AUTHORITY_DUE_TO_AGE_DISPUTE = new AuthErrorClassification(AADHAAR_SUSPENDED_BY_COMPETENT_AUTHORITY_DUE_TO_AGE_DISPUTE_TYPE, "AADHAAR_SUSPENDED_BY_COMPETENT_AUTHORITY_DUE_TO_AGE_DISPUTE");

    /**
     * The
     * AADHAAR_SUSPENDED_SINCE_CHILD_HAS_NOT_UPDATED_BIOMETRICS_AFTER_AGE_OF_5
     * type
     */
    public static final int AADHAAR_SUSPENDED_SINCE_CHILD_HAS_NOT_UPDATED_BIOMETRICS_AFTER_AGE_OF_5_TYPE = 26;

    /**
     * The instance of the
     * AADHAAR_SUSPENDED_SINCE_CHILD_HAS_NOT_UPDATED_BIOMETRICS_AFTER_AGE_OF_5
     * type
     */
    public static final AuthErrorClassification AADHAAR_SUSPENDED_SINCE_CHILD_HAS_NOT_UPDATED_BIOMETRICS_AFTER_AGE_OF_5 = new AuthErrorClassification(AADHAAR_SUSPENDED_SINCE_CHILD_HAS_NOT_UPDATED_BIOMETRICS_AFTER_AGE_OF_5_TYPE, "AADHAAR_SUSPENDED_SINCE_CHILD_HAS_NOT_UPDATED_BIOMETRICS_AFTER_AGE_OF_5");

    /**
     * The
     * AADHAAR_SUSPENDED_SINCE_CHILD_HAS_NOT_UPDATED_BIOMETRICS_AFTER_AGE_OF_15
     * type
     */
    public static final int AADHAAR_SUSPENDED_SINCE_CHILD_HAS_NOT_UPDATED_BIOMETRICS_AFTER_AGE_OF_15_TYPE = 27;

    /**
     * The instance of the
     * AADHAAR_SUSPENDED_SINCE_CHILD_HAS_NOT_UPDATED_BIOMETRICS_AFTER_AGE_OF_15
     * type
     */
    public static final AuthErrorClassification AADHAAR_SUSPENDED_SINCE_CHILD_HAS_NOT_UPDATED_BIOMETRICS_AFTER_AGE_OF_15 = new AuthErrorClassification(AADHAAR_SUSPENDED_SINCE_CHILD_HAS_NOT_UPDATED_BIOMETRICS_AFTER_AGE_OF_15_TYPE, "AADHAAR_SUSPENDED_SINCE_CHILD_HAS_NOT_UPDATED_BIOMETRICS_AFTER_AGE_OF_15");

    /**
     * The AADHAAR_LOCKED_BY_RESIDENT type
     */
    public static final int AADHAAR_LOCKED_BY_RESIDENT_TYPE = 28;

    /**
     * The instance of the AADHAAR_LOCKED_BY_RESIDENT type
     */
    public static final AuthErrorClassification AADHAAR_LOCKED_BY_RESIDENT = new AuthErrorClassification(AADHAAR_LOCKED_BY_RESIDENT_TYPE, "AADHAAR_LOCKED_BY_RESIDENT");

    /**
     * The
     * AADHAAR_SUSPENDED_BY_COMPETENT_AUTHORITY_DUE_TO_NON_RESIDENTSHIP
     * type
     */
    public static final int AADHAAR_SUSPENDED_BY_COMPETENT_AUTHORITY_DUE_TO_NON_RESIDENTSHIP_TYPE = 29;

    /**
     * The instance of the
     * AADHAAR_SUSPENDED_BY_COMPETENT_AUTHORITY_DUE_TO_NON_RESIDENTSHIP
     * type
     */
    public static final AuthErrorClassification AADHAAR_SUSPENDED_BY_COMPETENT_AUTHORITY_DUE_TO_NON_RESIDENTSHIP = new AuthErrorClassification(AADHAAR_SUSPENDED_BY_COMPETENT_AUTHORITY_DUE_TO_NON_RESIDENTSHIP_TYPE, "AADHAAR_SUSPENDED_BY_COMPETENT_AUTHORITY_DUE_TO_NON_RESIDENTSHIP");

    /**
     * The AADHAR_SUSPENDED_DUE_TO_DISPUTE_POI_OR_POA type
     */
    public static final int AADHAR_SUSPENDED_DUE_TO_DISPUTE_POI_OR_POA_TYPE = 30;

    /**
     * The instance of the
     * AADHAR_SUSPENDED_DUE_TO_DISPUTE_POI_OR_POA type
     */
    public static final AuthErrorClassification AADHAR_SUSPENDED_DUE_TO_DISPUTE_POI_OR_POA = new AuthErrorClassification(AADHAR_SUSPENDED_DUE_TO_DISPUTE_POI_OR_POA_TYPE, "AADHAR_SUSPENDED_DUE_TO_DISPUTE_POI_OR_POA");

    /**
     * The AADHAAR_DOES_NOT_VERIFIED_MOBILE_OR_EMAIL type
     */
    public static final int AADHAAR_DOES_NOT_VERIFIED_MOBILE_OR_EMAIL_TYPE = 31;

    /**
     * The instance of the
     * AADHAAR_DOES_NOT_VERIFIED_MOBILE_OR_EMAIL type
     */
    public static final AuthErrorClassification AADHAAR_DOES_NOT_VERIFIED_MOBILE_OR_EMAIL = new AuthErrorClassification(AADHAAR_DOES_NOT_VERIFIED_MOBILE_OR_EMAIL_TYPE, "AADHAAR_DOES_NOT_VERIFIED_MOBILE_OR_EMAIL");

    /**
     * The AADHAR_DOES_NOT_VERIRIED_MOBILE type
     */
    public static final int AADHAR_DOES_NOT_VERIRIED_MOBILE_TYPE = 32;

    /**
     * The instance of the AADHAR_DOES_NOT_VERIRIED_MOBILE type
     */
    public static final AuthErrorClassification AADHAR_DOES_NOT_VERIRIED_MOBILE = new AuthErrorClassification(AADHAR_DOES_NOT_VERIRIED_MOBILE_TYPE, "AADHAR_DOES_NOT_VERIRIED_MOBILE");

    /**
     * The AADHAR_DOES_NOT_HAVE_BOTH_EMAIL_MOBILE type
     */
    public static final int AADHAR_DOES_NOT_HAVE_BOTH_EMAIL_MOBILE_TYPE = 33;

    /**
     * The instance of the AADHAR_DOES_NOT_HAVE_BOTH_EMAIL_MOBILE
     * type
     */
    public static final AuthErrorClassification AADHAR_DOES_NOT_HAVE_BOTH_EMAIL_MOBILE = new AuthErrorClassification(AADHAR_DOES_NOT_HAVE_BOTH_EMAIL_MOBILE_TYPE, "AADHAR_DOES_NOT_HAVE_BOTH_EMAIL_MOBILE");

    /**
     * The INVALID_OTP_XML_FORMAT type
     */
    public static final int INVALID_OTP_XML_FORMAT_TYPE = 34;

    /**
     * The instance of the INVALID_OTP_XML_FORMAT type
     */
    public static final AuthErrorClassification INVALID_OTP_XML_FORMAT = new AuthErrorClassification(INVALID_OTP_XML_FORMAT_TYPE, "INVALID_OTP_XML_FORMAT");

    /**
     * The INVALID_DEVICE type
     */
    public static final int INVALID_DEVICE_TYPE = 35;

    /**
     * The instance of the INVALID_DEVICE type
     */
    public static final AuthErrorClassification INVALID_DEVICE = new AuthErrorClassification(INVALID_DEVICE_TYPE, "INVALID_DEVICE");

    /**
     * The INVALID_MOBILE_NUMBER type
     */
    public static final int INVALID_MOBILE_NUMBER_TYPE = 36;

    /**
     * The instance of the INVALID_MOBILE_NUMBER type
     */
    public static final AuthErrorClassification INVALID_MOBILE_NUMBER = new AuthErrorClassification(INVALID_MOBILE_NUMBER_TYPE, "INVALID_MOBILE_NUMBER");

    /**
     * The INVALID_TYPE_ATTRIBUTE type
     */
    public static final int INVALID_TYPE_ATTRIBUTE_TYPE = 37;

    /**
     * The instance of the INVALID_TYPE_ATTRIBUTE type
     */
    public static final AuthErrorClassification INVALID_TYPE_ATTRIBUTE = new AuthErrorClassification(INVALID_TYPE_ATTRIBUTE_TYPE, "INVALID_TYPE_ATTRIBUTE");

    /**
     * The INVALID_AUA_CODE type
     */
    public static final int INVALID_AUA_CODE_TYPE = 38;

    /**
     * The instance of the INVALID_AUA_CODE type
     */
    public static final AuthErrorClassification INVALID_AUA_CODE = new AuthErrorClassification(INVALID_AUA_CODE_TYPE, "INVALID_AUA_CODE");

    /**
     * The INVALID_OTP_XML_VERSION type
     */
    public static final int INVALID_OTP_XML_VERSION_TYPE = 39;

    /**
     * The instance of the INVALID_OTP_XML_VERSION type
     */
    public static final AuthErrorClassification INVALID_OTP_XML_VERSION = new AuthErrorClassification(INVALID_OTP_XML_VERSION_TYPE, "INVALID_OTP_XML_VERSION");

    /**
     * The AUA_NOT_AUTHORIZED_FOR_ASA type
     */
    public static final int AUA_NOT_AUTHORIZED_FOR_ASA_TYPE = 40;

    /**
     * The instance of the AUA_NOT_AUTHORIZED_FOR_ASA type
     */
    public static final AuthErrorClassification AUA_NOT_AUTHORIZED_FOR_ASA = new AuthErrorClassification(AUA_NOT_AUTHORIZED_FOR_ASA_TYPE, "AUA_NOT_AUTHORIZED_FOR_ASA");

    /**
     * The SUBAUA_NOT_ASSOCIATED_WITH_AUA type
     */
    public static final int SUBAUA_NOT_ASSOCIATED_WITH_AUA_TYPE = 41;

    /**
     * The instance of the SUBAUA_NOT_ASSOCIATED_WITH_AUA type
     */
    public static final AuthErrorClassification SUBAUA_NOT_ASSOCIATED_WITH_AUA = new AuthErrorClassification(SUBAUA_NOT_ASSOCIATED_WITH_AUA_TYPE, "SUBAUA_NOT_ASSOCIATED_WITH_AUA");

    /**
     * The AUA_LICENSE_KEY_HAS_EXPIRED_OR_INVALID type
     */
    public static final int AUA_LICENSE_KEY_HAS_EXPIRED_OR_INVALID_TYPE = 42;

    /**
     * The instance of the AUA_LICENSE_KEY_HAS_EXPIRED_OR_INVALID
     * type
     */
    public static final AuthErrorClassification AUA_LICENSE_KEY_HAS_EXPIRED_OR_INVALID = new AuthErrorClassification(AUA_LICENSE_KEY_HAS_EXPIRED_OR_INVALID_TYPE, "AUA_LICENSE_KEY_HAS_EXPIRED_OR_INVALID");

    /**
     * The ASA_LICENSE_KEY_HAS_EXPIRED_OR_INVALID type
     */
    public static final int ASA_LICENSE_KEY_HAS_EXPIRED_OR_INVALID_TYPE = 43;

    /**
     * The instance of the ASA_LICENSE_KEY_HAS_EXPIRED_OR_INVALID
     * type
     */
    public static final AuthErrorClassification ASA_LICENSE_KEY_HAS_EXPIRED_OR_INVALID = new AuthErrorClassification(ASA_LICENSE_KEY_HAS_EXPIRED_OR_INVALID_TYPE, "ASA_LICENSE_KEY_HAS_EXPIRED_OR_INVALID");

    /**
     * The DIGITAL_SIGNATURE_VERIFICATION_FAILED type
     */
    public static final int DIGITAL_SIGNATURE_VERIFICATION_FAILED_TYPE = 44;

    /**
     * The instance of the DIGITAL_SIGNATURE_VERIFICATION_FAILED typ
     */
    public static final AuthErrorClassification DIGITAL_SIGNATURE_VERIFICATION_FAILED = new AuthErrorClassification(DIGITAL_SIGNATURE_VERIFICATION_FAILED_TYPE, "DIGITAL_SIGNATURE_VERIFICATION_FAILED");

    /**
     * The INVALID_KEY_INFO_DIGITAL_SIGNATURE type
     */
    public static final int INVALID_KEY_INFO_DIGITAL_SIGNATURE_TYPE = 45;

    /**
     * The instance of the INVALID_KEY_INFO_DIGITAL_SIGNATURE type
     */
    public static final AuthErrorClassification INVALID_KEY_INFO_DIGITAL_SIGNATURE = new AuthErrorClassification(INVALID_KEY_INFO_DIGITAL_SIGNATURE_TYPE, "INVALID_KEY_INFO_DIGITAL_SIGNATURE");

    /**
     * The UNAUTHORIZED_ASA_CHANNEL type
     */
    public static final int UNAUTHORIZED_ASA_CHANNEL_TYPE = 46;

    /**
     * The instance of the UNAUTHORIZED_ASA_CHANNEL type
     */
    public static final AuthErrorClassification UNAUTHORIZED_ASA_CHANNEL = new AuthErrorClassification(UNAUTHORIZED_ASA_CHANNEL_TYPE, "UNAUTHORIZED_ASA_CHANNEL");

    /**
     * The UNSPECIFIED_ASA_CHANNEL type
     */
    public static final int UNSPECIFIED_ASA_CHANNEL_TYPE = 47;

    /**
     * The instance of the UNSPECIFIED_ASA_CHANNEL type
     */
    public static final AuthErrorClassification UNSPECIFIED_ASA_CHANNEL = new AuthErrorClassification(UNSPECIFIED_ASA_CHANNEL_TYPE, "UNSPECIFIED_ASA_CHANNEL");

    /**
     * The COULDNOT_GENERATE_AND_OR_SEND_OTP type
     */
    public static final int COULDNOT_GENERATE_AND_OR_SEND_OTP_TYPE = 48;

    /**
     * The instance of the COULDNOT_GENERATE_AND_OR_SEND_OTP type
     */
    public static final AuthErrorClassification COULDNOT_GENERATE_AND_OR_SEND_OTP = new AuthErrorClassification(COULDNOT_GENERATE_AND_OR_SEND_OTP_TYPE, "COULDNOT_GENERATE_AND_OR_SEND_OTP");

    /**
     * The UNKNOWN_ERROR type
     */
    public static final int UNKNOWN_ERROR_TYPE = 49;

    /**
     * The instance of the UNKNOWN_ERROR type
     */
    public static final AuthErrorClassification UNKNOWN_ERROR = new AuthErrorClassification(UNKNOWN_ERROR_TYPE, "UNKNOWN_ERROR");

    /**
     * The INVALID_TS_ATTRIBUTE type
     */
    public static final int INVALID_TS_ATTRIBUTE_TYPE = 50;

    /**
     * The instance of the INVALID_TS_ATTRIBUTE type
     */
    public static final AuthErrorClassification INVALID_TS_ATTRIBUTE = new AuthErrorClassification(INVALID_TS_ATTRIBUTE_TYPE, "INVALID_TS_ATTRIBUTE");

    /**
     * Field _memberTable
     */
    private static Hashtable _memberTable = init();

    /**
     * Field type
     */
    private int type = -1;

    /**
     * Field stringValue
     */
    private String stringValue = null;


      //----------------/
     //- Constructors -/
    //----------------/

    private AuthErrorClassification(int type, String value)
     {
        super();
        this.type = type;
        this.stringValue = value;
    } //-- auth_2_0.types.AuthErrorClassification(int, java.lang.String)


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Method enumerate
     * 
     * Returns an enumeration of all possible instances of
     * AuthErrorClassification
     * 
     * @return Enumeration
     */
    public static Enumeration enumerate()
    {
        return _memberTable.elements();
    } //-- java.util.Enumeration enumerate() 

    /**
     * Method getType
     * 
     * Returns the type of this AuthErrorClassification
     * 
     * @return int
     */
    public int getType()
    {
        return this.type;
    } //-- int getType() 

    /**
     * Method init
     * 
     * 
     * 
     * @return Hashtable
     */
    private static Hashtable init()
    {
        Hashtable members = new Hashtable();
        members.put("UID_NOT_FOUND", UID_NOT_FOUND);
        members.put("INVALID_UID_STATUS", INVALID_UID_STATUS);
        members.put("INVALID_UID", INVALID_UID);
        members.put("UID_INACTIVE", UID_INACTIVE);
        members.put("UID_BLOCKED", UID_BLOCKED);
        members.put("UID_DESEASED", UID_DESEASED);
        members.put("UID_CANCELLED", UID_CANCELLED);
        members.put("INCORRECT_PIN", INCORRECT_PIN);
        members.put("INCORRECT_OTP", INCORRECT_OTP);
        members.put("TKN_MISMATCH", TKN_MISMATCH);
        members.put("FRAUD_CHECK_FAILED", FRAUD_CHECK_FAILED);
        members.put("NO_BIOMETRIC_GALLERY", NO_BIOMETRIC_GALLERY);
        members.put("TID_NOT_FOUND", TID_NOT_FOUND);
        members.put("BIOMETRIC_LOCKED", BIOMETRIC_LOCKED);
        members.put("BIOMETRIC_LOCK_RELATED_TECHNICAL_ERROR", BIOMETRIC_LOCK_RELATED_TECHNICAL_ERROR);
        members.put("AADHAAR_SUSPENDED_DUE_TO_INACTIVITY", AADHAAR_SUSPENDED_DUE_TO_INACTIVITY);
        members.put("AADHAAR_CANCELED_DUE_TO_DUPLICATE", AADHAAR_CANCELED_DUE_TO_DUPLICATE);
        members.put("AADHAAR_CANCELED_DUE_TO_FRUAD_ENROLMENTS", AADHAAR_CANCELED_DUE_TO_FRUAD_ENROLMENTS);
        members.put("AADHAAR_CANCELED_FOR_TEST_CASES_OR_TECHINICAL_ISSUES", AADHAAR_CANCELED_FOR_TEST_CASES_OR_TECHINICAL_ISSUES);
        members.put("AADHAAR_CANCELED_DUE_TO_BIOMETRIC_EXCEPTION_CASES", AADHAAR_CANCELED_DUE_TO_BIOMETRIC_EXCEPTION_CASES);
        members.put("AADHAAR_CANCELED_DUE_TO_COGENT_FLIP_IRIS_CASES", AADHAAR_CANCELED_DUE_TO_COGENT_FLIP_IRIS_CASES);
        members.put("AADHAAR_SUSPENDED_FOR_BIOMETRIC_UPDATE", AADHAAR_SUSPENDED_FOR_BIOMETRIC_UPDATE);
        members.put("AADHAAR_SUSPENDED_FOR_DEMOGRAPHIC_UPDATE", AADHAAR_SUSPENDED_FOR_DEMOGRAPHIC_UPDATE);
        members.put("AADHAAR_SUSPENDED_BY_COMPETENT_AUTHORITY_DUE_TO_ADDRESS_DISPUTE", AADHAAR_SUSPENDED_BY_COMPETENT_AUTHORITY_DUE_TO_ADDRESS_DISPUTE);
        members.put("AADHAAR_SUSPENDED_BY_COMPETENT_AUTHORITY_DUE_TO_PHOTO_DISPUTE", AADHAAR_SUSPENDED_BY_COMPETENT_AUTHORITY_DUE_TO_PHOTO_DISPUTE);
        members.put("AADHAAR_SUSPENDED_BY_COMPETENT_AUTHORITY_DUE_TO_AGE_DISPUTE", AADHAAR_SUSPENDED_BY_COMPETENT_AUTHORITY_DUE_TO_AGE_DISPUTE);
        members.put("AADHAAR_SUSPENDED_SINCE_CHILD_HAS_NOT_UPDATED_BIOMETRICS_AFTER_AGE_OF_5", AADHAAR_SUSPENDED_SINCE_CHILD_HAS_NOT_UPDATED_BIOMETRICS_AFTER_AGE_OF_5);
        members.put("AADHAAR_SUSPENDED_SINCE_CHILD_HAS_NOT_UPDATED_BIOMETRICS_AFTER_AGE_OF_15", AADHAAR_SUSPENDED_SINCE_CHILD_HAS_NOT_UPDATED_BIOMETRICS_AFTER_AGE_OF_15);
        members.put("AADHAAR_LOCKED_BY_RESIDENT", AADHAAR_LOCKED_BY_RESIDENT);
        members.put("AADHAAR_SUSPENDED_BY_COMPETENT_AUTHORITY_DUE_TO_NON_RESIDENTSHIP", AADHAAR_SUSPENDED_BY_COMPETENT_AUTHORITY_DUE_TO_NON_RESIDENTSHIP);
        members.put("AADHAR_SUSPENDED_DUE_TO_DISPUTE_POI_OR_POA", AADHAR_SUSPENDED_DUE_TO_DISPUTE_POI_OR_POA);
        members.put("AADHAAR_DOES_NOT_VERIFIED_MOBILE_OR_EMAIL", AADHAAR_DOES_NOT_VERIFIED_MOBILE_OR_EMAIL);
        members.put("AADHAR_DOES_NOT_VERIRIED_MOBILE", AADHAR_DOES_NOT_VERIRIED_MOBILE);
        members.put("AADHAR_DOES_NOT_HAVE_BOTH_EMAIL_MOBILE", AADHAR_DOES_NOT_HAVE_BOTH_EMAIL_MOBILE);
        members.put("INVALID_OTP_XML_FORMAT", INVALID_OTP_XML_FORMAT);
        members.put("INVALID_DEVICE", INVALID_DEVICE);
        members.put("INVALID_MOBILE_NUMBER", INVALID_MOBILE_NUMBER);
        members.put("INVALID_TYPE_ATTRIBUTE", INVALID_TYPE_ATTRIBUTE);
        members.put("INVALID_AUA_CODE", INVALID_AUA_CODE);
        members.put("INVALID_OTP_XML_VERSION", INVALID_OTP_XML_VERSION);
        members.put("AUA_NOT_AUTHORIZED_FOR_ASA", AUA_NOT_AUTHORIZED_FOR_ASA);
        members.put("SUBAUA_NOT_ASSOCIATED_WITH_AUA", SUBAUA_NOT_ASSOCIATED_WITH_AUA);
        members.put("AUA_LICENSE_KEY_HAS_EXPIRED_OR_INVALID", AUA_LICENSE_KEY_HAS_EXPIRED_OR_INVALID);
        members.put("ASA_LICENSE_KEY_HAS_EXPIRED_OR_INVALID", ASA_LICENSE_KEY_HAS_EXPIRED_OR_INVALID);
        members.put("DIGITAL_SIGNATURE_VERIFICATION_FAILED", DIGITAL_SIGNATURE_VERIFICATION_FAILED);
        members.put("INVALID_KEY_INFO_DIGITAL_SIGNATURE", INVALID_KEY_INFO_DIGITAL_SIGNATURE);
        members.put("UNAUTHORIZED_ASA_CHANNEL", UNAUTHORIZED_ASA_CHANNEL);
        members.put("UNSPECIFIED_ASA_CHANNEL", UNSPECIFIED_ASA_CHANNEL);
        members.put("COULDNOT_GENERATE_AND_OR_SEND_OTP", COULDNOT_GENERATE_AND_OR_SEND_OTP);
        members.put("UNKNOWN_ERROR", UNKNOWN_ERROR);
        members.put("INVALID_TS_ATTRIBUTE", INVALID_TS_ATTRIBUTE);
        return members;
    } //-- java.util.Hashtable init() 

    /**
     * Method readResolve
     * 
     *  will be called during deserialization to replace the
     * deserialized object with the correct constant instance.
     * <br/>
     * 
     * @return Object
     */
    private Object readResolve()
    {
        return valueOf(this.stringValue);
    } //-- java.lang.Object readResolve() 

    /**
     * Method toString
     * 
     * Returns the String representation of this
     * AuthErrorClassification
     * 
     * @return String
     */
    public String toString()
    {
        return this.stringValue;
    } //-- java.lang.String toString() 

    /**
     * Method valueOf
     * 
     * Returns a new AuthErrorClassification based on the given
     * String value.
     * 
     * @param string
     * @return AuthErrorClassification
     */
    public static auth_2_0.types.AuthErrorClassification valueOf(String string)
    {
        Object obj = null;
        if (string != null) obj = _memberTable.get(string);
        if (obj == null) {
            String err = "'" + string + "' is not a valid AuthErrorClassification";
            throw new IllegalArgumentException(err);
        }
        return (AuthErrorClassification) obj;
    } //-- auth_2_0.types.AuthErrorClassification valueOf(java.lang.String) 

}
