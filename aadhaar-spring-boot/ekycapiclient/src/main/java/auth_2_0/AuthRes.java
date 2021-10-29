/*
 * This class was automatically generated with 
 * <a href="http://www.castor.org">Castor 0.9.7</a>, using an XML
 * Schema.
 * $Id$
 */

package auth_2_0;

  //---------------------------------/
 //- Imported classes and packages -/
//---------------------------------/

import java.io.IOException;
import java.io.Reader;
import java.io.Serializable;
import java.io.Writer;
import java.util.Date;

import auth_2_0.types.AuthErrorCode;
import auth_2_0.types.AuthResult;
import org.exolab.castor.xml.MarshalException;
import org.exolab.castor.xml.Marshaller;
import org.exolab.castor.xml.Unmarshaller;
import org.exolab.castor.xml.ValidationException;
import org.xml.sax.ContentHandler;

/**
 * Class AuthRes.
 * 
 * @version $Revision$ $Date$
 */
public class AuthRes implements Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Authentication response - 'y' for
     *  authentication success, 'n' for authentication failure
     *  
     */
    private AuthResult _ret;

    /**
     * Unique alphanumeric authentication response
     *  code. In the case of any dispute, this can be used later to
     * verify
     *  the authentication. UID application will retain
     * authentication
     *  trail only for a short time as per UID policy. After that
     * period,
     *  this code will become unusable.
     *  
     */
    private String _code;

    /**
     * Authenticator specific transaction
     *  identifier. This is exactly same value as in the request
     *  
     */
    private String _txn;

    /**
     * Failure error code. If authentication
     *  fails (“ret” attribute value is “n”), this attribute
     * provides additional details.
     *  Refer AADAHAR API Specification on UIDAI Website for
     * further details
     *  
     */
    private AuthErrorCode _err;

    /**
     * uidstatus action codes
     *  
     */
    private String _actn;

    /**
     * This attribute is a value with up to 128 characters, and is
     * composed of following
     *  parts:
     *  (Version) + (SHA-256 hash of Aadhaar number) + (Encoded
     * UIDAI Data)
     *  
     */
    private String _info;

    /**
     * Authentication timestamp.
     *  Represents the timestamp at which authentication response
     * was generated.
     *  
     */
    private Date _ts;


      //----------------/
     //- Constructors -/
    //----------------/

    public AuthRes() 
     {
        super();
    } //-- auth_2_0.AuthRes()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Returns the value of field 'actn'. The field 'actn' has the
     * following description: uidstatus action codes
     *  
     * 
     * @return String
     * @return the value of field 'actn'.
     */
    public String getActn()
    {
        return this._actn;
    } //-- java.lang.String getActn() 

    /**
     * Returns the value of field 'code'. The field 'code' has the
     * following description: Unique alphanumeric authentication
     * response
     *  code. In the case of any dispute, this can be used later to
     * verify
     *  the authentication. UID application will retain
     * authentication
     *  trail only for a short time as per UID policy. After that
     * period,
     *  this code will become unusable.
     *  
     * 
     * @return String
     * @return the value of field 'code'.
     */
    public String getCode()
    {
        return this._code;
    } //-- java.lang.String getCode() 

    /**
     * Returns the value of field 'err'. The field 'err' has the
     * following description: Failure error code. If authentication
     *  fails (“ret” attribute value is “n”), this attribute
     * provides additional details.
     *  Refer AADAHAR API Specification on UIDAI Website for
     * further details
     *  
     * 
     * @return AuthErrorCode
     * @return the value of field 'err'.
     */
    public AuthErrorCode getErr()
    {
        return this._err;
    } //-- auth_2_0.types.AuthErrorCode getErr() 

    /**
     * Returns the value of field 'info'. The field 'info' has the
     * following description: This attribute is a value with up to
     * 128 characters, and is composed of following
     *  parts:
     *  (Version) + (SHA-256 hash of Aadhaar number) + (Encoded
     * UIDAI Data)
     *  
     * 
     * @return String
     * @return the value of field 'info'.
     */
    public String getInfo()
    {
        return this._info;
    } //-- java.lang.String getInfo() 

    /**
     * Returns the value of field 'ret'. The field 'ret' has the
     * following description: Authentication response - 'y' for
     *  authentication success, 'n' for authentication failure
     *  
     * 
     * @return AuthResult
     * @return the value of field 'ret'.
     */
    public AuthResult getRet()
    {
        return this._ret;
    } //-- auth_2_0.types.AuthResult getRet() 

    /**
     * Returns the value of field 'ts'. The field 'ts' has the
     * following description: Authentication timestamp.
     *  Represents the timestamp at which authentication response
     * was generated.
     *  
     * 
     * @return Date
     * @return the value of field 'ts'.
     */
    public Date getTs()
    {
        return this._ts;
    } //-- java.util.Date getTs() 

    /**
     * Returns the value of field 'txn'. The field 'txn' has the
     * following description: Authenticator specific transaction
     *  identifier. This is exactly same value as in the request
     *  
     * 
     * @return String
     * @return the value of field 'txn'.
     */
    public String getTxn()
    {
        return this._txn;
    } //-- java.lang.String getTxn() 

    /**
     * Method isValid
     * 
     * 
     * 
     * @return boolean
     */
    public boolean isValid()
    {
        try {
            validate();
        }
        catch (ValidationException vex) {
            return false;
        }
        return true;
    } //-- boolean isValid() 

    /**
     * Method marshal
     * 
     * 
     * 
     * @param out
     */
    public void marshal(Writer out)
        throws MarshalException, ValidationException
    {
        
        Marshaller.marshal(this, out);
    } //-- void marshal(java.io.Writer) 

    /**
     * Method marshal
     * 
     * 
     * 
     * @param handler
     */
    public void marshal(ContentHandler handler)
        throws IOException, MarshalException, ValidationException
    {
        
        Marshaller.marshal(this, handler);
    } //-- void marshal(org.xml.sax.ContentHandler) 

    /**
     * Sets the value of field 'actn'. The field 'actn' has the
     * following description: uidstatus action codes
     *  
     * 
     * @param actn the value of field 'actn'.
     */
    public void setActn(String actn)
    {
        this._actn = actn;
    } //-- void setActn(java.lang.String) 

    /**
     * Sets the value of field 'code'. The field 'code' has the
     * following description: Unique alphanumeric authentication
     * response
     *  code. In the case of any dispute, this can be used later to
     * verify
     *  the authentication. UID application will retain
     * authentication
     *  trail only for a short time as per UID policy. After that
     * period,
     *  this code will become unusable.
     *  
     * 
     * @param code the value of field 'code'.
     */
    public void setCode(String code)
    {
        this._code = code;
    } //-- void setCode(java.lang.String) 

    /**
     * Sets the value of field 'err'. The field 'err' has the
     * following description: Failure error code. If authentication
     *  fails (“ret” attribute value is “n”), this attribute
     * provides additional details.
     *  Refer AADAHAR API Specification on UIDAI Website for
     * further details
     *  
     * 
     * @param err the value of field 'err'.
     */
    public void setErr(AuthErrorCode err)
    {
        this._err = err;
    } //-- void setErr(auth_2_0.types.AuthErrorCode) 

    /**
     * Sets the value of field 'info'. The field 'info' has the
     * following description: This attribute is a value with up to
     * 128 characters, and is composed of following
     *  parts:
     *  (Version) + (SHA-256 hash of Aadhaar number) + (Encoded
     * UIDAI Data)
     *  
     * 
     * @param info the value of field 'info'.
     */
    public void setInfo(String info)
    {
        this._info = info;
    } //-- void setInfo(java.lang.String) 

    /**
     * Sets the value of field 'ret'. The field 'ret' has the
     * following description: Authentication response - 'y' for
     *  authentication success, 'n' for authentication failure
     *  
     * 
     * @param ret the value of field 'ret'.
     */
    public void setRet(AuthResult ret)
    {
        this._ret = ret;
    } //-- void setRet(auth_2_0.types.AuthResult) 

    /**
     * Sets the value of field 'ts'. The field 'ts' has the
     * following description: Authentication timestamp.
     *  Represents the timestamp at which authentication response
     * was generated.
     *  
     * 
     * @param ts the value of field 'ts'.
     */
    public void setTs(Date ts)
    {
        this._ts = ts;
    } //-- void setTs(java.util.Date) 

    /**
     * Sets the value of field 'txn'. The field 'txn' has the
     * following description: Authenticator specific transaction
     *  identifier. This is exactly same value as in the request
     *  
     * 
     * @param txn the value of field 'txn'.
     */
    public void setTxn(String txn)
    {
        this._txn = txn;
    } //-- void setTxn(java.lang.String) 

    /**
     * Method unmarshalAuthRes
     * 
     * 
     * 
     * @param reader
     * @return Object
     */
    public static Object unmarshalAuthRes(Reader reader)
        throws MarshalException, ValidationException
    {
        return (AuthRes) Unmarshaller.unmarshal(AuthRes.class, reader);
    } //-- java.lang.Object unmarshalAuthRes(java.io.Reader) 

    /**
     * Method validate
     * 
     */
    public void validate()
        throws ValidationException
    {
        org.exolab.castor.xml.Validator validator = new org.exolab.castor.xml.Validator();
        validator.validate(this);
    } //-- void validate() 

}
