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

import auth_2_0.types.AuthRcType;
import java.io.IOException;
import java.io.Reader;
import java.io.Serializable;
import java.io.Writer;
import org.exolab.castor.xml.MarshalException;
import org.exolab.castor.xml.Marshaller;
import org.exolab.castor.xml.Unmarshaller;
import org.exolab.castor.xml.ValidationException;
import org.xml.sax.ContentHandler;

/**
 * Class Auth.
 * 
 * @version $Revision$ $Date$
 */
public class Auth implements Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * UID number of the resident
     */
    private String _uid;

    /**
     * Authenticator Code, or "public" if
     *  authenticator
     *  code is not available.
     *  
     */
    private String _ac;

    /**
     * Unique Terminal ID of the device
     *  
     */
    private String _tid;

    /**
     * Version of the API. Defaulted to latest
     *  version
     *  
     */
    private String _ver = "2.0";

    /**
     * Authenticator specific transaction identifier
     *  
     */
    private String _txn;

    /**
     * AUA License key
     *  
     */
    private String _lk;

    /**
     * Service Agency
     *  
     */
    private String _sa;

    /**
     * Consent of the resident
     */
    private AuthRcType _rc;

    /**
     * In the case where Authenticator does not have
     *  full control over the terminal devices, it is highly
     * recommended
     *  that this element be used to add the minimum usage
     * criteria.
     *  
     */
    private auth_2_0.Uses _uses;

    /**
     * Meta data related to device and transaction.
     *  
     */
    private auth_2_0.Meta _meta;

    /**
     * Value of this element is base-64 encoded value of
     *  encrypted session key.
     *  
     */
    private auth_2_0.Skey _skey;

    /**
     * Field _data
     */
    private auth_2_0.Data _data;

    /**
     * Field _hmac
     */
    private byte[] _hmac;


      //----------------/
     //- Constructors -/
    //----------------/

    public Auth() 
     {
        super();
        setVer("2.0");
    } //-- auth_2_0.Auth()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Returns the value of field 'ac'. The field 'ac' has the
     * following description: Authenticator Code, or "public" if
     *  authenticator
     *  code is not available.
     *  
     * 
     * @return String
     * @return the value of field 'ac'.
     */
    public String getAc()
    {
        return this._ac;
    } //-- java.lang.String getAc() 

    /**
     * Returns the value of field 'data'.
     * 
     * @return Data
     * @return the value of field 'data'.
     */
    public auth_2_0.Data getData()
    {
        return this._data;
    } //-- auth_2_0.Data getData() 

    /**
     * Returns the value of field 'hmac'.
     * 
     * @return byte
     * @return the value of field 'hmac'.
     */
    public byte[] getHmac()
    {
        return this._hmac;
    } //-- byte[] getHmac() 

    /**
     * Returns the value of field 'lk'. The field 'lk' has the
     * following description: AUA License key
     *  
     * 
     * @return String
     * @return the value of field 'lk'.
     */
    public String getLk()
    {
        return this._lk;
    } //-- java.lang.String getLk() 

    /**
     * Returns the value of field 'meta'. The field 'meta' has the
     * following description: Meta data related to device and
     * transaction.
     *  
     * 
     * @return Meta
     * @return the value of field 'meta'.
     */
    public auth_2_0.Meta getMeta()
    {
        return this._meta;
    } //-- auth_2_0.Meta getMeta() 

    /**
     * Returns the value of field 'rc'. The field 'rc' has the
     * following description: Consent of the resident
     * 
     * @return AuthRcType
     * @return the value of field 'rc'.
     */
    public AuthRcType getRc()
    {
        return this._rc;
    } //-- auth_2_0.types.AuthRcType getRc() 

    /**
     * Returns the value of field 'sa'. The field 'sa' has the
     * following description: Service Agency
     *  
     * 
     * @return String
     * @return the value of field 'sa'.
     */
    public String getSa()
    {
        return this._sa;
    } //-- java.lang.String getSa() 

    /**
     * Returns the value of field 'skey'. The field 'skey' has the
     * following description: Value of this element is base-64
     * encoded value of
     *  encrypted session key.
     *  
     * 
     * @return Skey
     * @return the value of field 'skey'.
     */
    public auth_2_0.Skey getSkey()
    {
        return this._skey;
    } //-- auth_2_0.Skey getSkey() 

    /**
     * Returns the value of field 'tid'. The field 'tid' has the
     * following description: Unique Terminal ID of the device
     *  
     * 
     * @return String
     * @return the value of field 'tid'.
     */
    public String getTid()
    {
        return this._tid;
    } //-- java.lang.String getTid() 

    /**
     * Returns the value of field 'txn'. The field 'txn' has the
     * following description: Authenticator specific transaction
     * identifier
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
     * Returns the value of field 'uid'. The field 'uid' has the
     * following description: UID number of the resident
     * 
     * @return String
     * @return the value of field 'uid'.
     */
    public String getUid()
    {
        return this._uid;
    } //-- java.lang.String getUid() 

    /**
     * Returns the value of field 'uses'. The field 'uses' has the
     * following description: In the case where Authenticator does
     * not have
     *  full control over the terminal devices, it is highly
     * recommended
     *  that this element be used to add the minimum usage
     * criteria.
     *  
     * 
     * @return Uses
     * @return the value of field 'uses'.
     */
    public auth_2_0.Uses getUses()
    {
        return this._uses;
    } //-- auth_2_0.Uses getUses() 

    /**
     * Returns the value of field 'ver'. The field 'ver' has the
     * following description: Version of the API. Defaulted to
     * latest
     *  version
     *  
     * 
     * @return String
     * @return the value of field 'ver'.
     */
    public String getVer()
    {
        return this._ver;
    } //-- java.lang.String getVer() 

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
     * Sets the value of field 'ac'. The field 'ac' has the
     * following description: Authenticator Code, or "public" if
     *  authenticator
     *  code is not available.
     *  
     * 
     * @param ac the value of field 'ac'.
     */
    public void setAc(String ac)
    {
        this._ac = ac;
    } //-- void setAc(java.lang.String) 

    /**
     * Sets the value of field 'data'.
     * 
     * @param data the value of field 'data'.
     */
    public void setData(auth_2_0.Data data)
    {
        this._data = data;
    } //-- void setData(auth_2_0.Data) 

    /**
     * Sets the value of field 'hmac'.
     * 
     * @param hmac the value of field 'hmac'.
     */
    public void setHmac(byte[] hmac)
    {
        this._hmac = hmac;
    } //-- void setHmac(byte) 

    /**
     * Sets the value of field 'lk'. The field 'lk' has the
     * following description: AUA License key
     *  
     * 
     * @param lk the value of field 'lk'.
     */
    public void setLk(String lk)
    {
        this._lk = lk;
    } //-- void setLk(java.lang.String) 

    /**
     * Sets the value of field 'meta'. The field 'meta' has the
     * following description: Meta data related to device and
     * transaction.
     *  
     * 
     * @param meta the value of field 'meta'.
     */
    public void setMeta(auth_2_0.Meta meta)
    {
        this._meta = meta;
    } //-- void setMeta(auth_2_0.Meta) 

    /**
     * Sets the value of field 'rc'. The field 'rc' has the
     * following description: Consent of the resident
     * 
     * @param rc the value of field 'rc'.
     */
    public void setRc(AuthRcType rc)
    {
        this._rc = rc;
    } //-- void setRc(auth_2_0.types.AuthRcType) 

    /**
     * Sets the value of field 'sa'. The field 'sa' has the
     * following description: Service Agency
     *  
     * 
     * @param sa the value of field 'sa'.
     */
    public void setSa(String sa)
    {
        this._sa = sa;
    } //-- void setSa(java.lang.String) 

    /**
     * Sets the value of field 'skey'. The field 'skey' has the
     * following description: Value of this element is base-64
     * encoded value of
     *  encrypted session key.
     *  
     * 
     * @param skey the value of field 'skey'.
     */
    public void setSkey(auth_2_0.Skey skey)
    {
        this._skey = skey;
    } //-- void setSkey(auth_2_0.Skey) 

    /**
     * Sets the value of field 'tid'. The field 'tid' has the
     * following description: Unique Terminal ID of the device
     *  
     * 
     * @param tid the value of field 'tid'.
     */
    public void setTid(String tid)
    {
        this._tid = tid;
    } //-- void setTid(java.lang.String) 

    /**
     * Sets the value of field 'txn'. The field 'txn' has the
     * following description: Authenticator specific transaction
     * identifier
     *  
     * 
     * @param txn the value of field 'txn'.
     */
    public void setTxn(String txn)
    {
        this._txn = txn;
    } //-- void setTxn(java.lang.String) 

    /**
     * Sets the value of field 'uid'. The field 'uid' has the
     * following description: UID number of the resident
     * 
     * @param uid the value of field 'uid'.
     */
    public void setUid(String uid)
    {
        this._uid = uid;
    } //-- void setUid(java.lang.String) 

    /**
     * Sets the value of field 'uses'. The field 'uses' has the
     * following description: In the case where Authenticator does
     * not have
     *  full control over the terminal devices, it is highly
     * recommended
     *  that this element be used to add the minimum usage
     * criteria.
     *  
     * 
     * @param uses the value of field 'uses'.
     */
    public void setUses(auth_2_0.Uses uses)
    {
        this._uses = uses;
    } //-- void setUses(auth_2_0.Uses) 

    /**
     * Sets the value of field 'ver'. The field 'ver' has the
     * following description: Version of the API. Defaulted to
     * latest
     *  version
     *  
     * 
     * @param ver the value of field 'ver'.
     */
    public void setVer(String ver)
    {
        this._ver = ver;
    } //-- void setVer(java.lang.String) 

    /**
     * Method unmarshalAuth
     * 
     * 
     * 
     * @param reader
     * @return Object
     */
    public static Object unmarshalAuth(Reader reader)
        throws MarshalException, ValidationException
    {
        return (auth_2_0.Auth) Unmarshaller.unmarshal(auth_2_0.Auth.class, reader);
    } //-- java.lang.Object unmarshalAuth(java.io.Reader) 

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
