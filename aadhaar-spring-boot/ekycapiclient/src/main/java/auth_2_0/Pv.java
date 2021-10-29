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
import org.exolab.castor.xml.MarshalException;
import org.exolab.castor.xml.Marshaller;
import org.exolab.castor.xml.Unmarshaller;
import org.exolab.castor.xml.ValidationException;
import org.xml.sax.ContentHandler;

/**
 * Class Pv.
 * 
 * @version $Revision$ $Date$
 */
public class Pv implements Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Most recently activated
     *  challenge-response OTP value for resident.
     *  
     */
    private String _otp;

    /**
     * Actual value of numeric pin
     *  as set by
     *  resident.
     *  
     */
    private String _pin;


      //----------------/
     //- Constructors -/
    //----------------/

    public Pv() 
     {
        super();
    } //-- auth_2_0.Pv()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Returns the value of field 'otp'. The field 'otp' has the
     * following description: Most recently activated
     *  challenge-response OTP value for resident.
     *  
     * 
     * @return String
     * @return the value of field 'otp'.
     */
    public String getOtp()
    {
        return this._otp;
    } //-- java.lang.String getOtp() 

    /**
     * Returns the value of field 'pin'. The field 'pin' has the
     * following description: Actual value of numeric pin
     *  as set by
     *  resident.
     *  
     * 
     * @return String
     * @return the value of field 'pin'.
     */
    public String getPin()
    {
        return this._pin;
    } //-- java.lang.String getPin() 

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
     * Sets the value of field 'otp'. The field 'otp' has the
     * following description: Most recently activated
     *  challenge-response OTP value for resident.
     *  
     * 
     * @param otp the value of field 'otp'.
     */
    public void setOtp(String otp)
    {
        this._otp = otp;
    } //-- void setOtp(java.lang.String) 

    /**
     * Sets the value of field 'pin'. The field 'pin' has the
     * following description: Actual value of numeric pin
     *  as set by
     *  resident.
     *  
     * 
     * @param pin the value of field 'pin'.
     */
    public void setPin(String pin)
    {
        this._pin = pin;
    } //-- void setPin(java.lang.String) 

    /**
     * Method unmarshalPv
     * 
     * 
     * 
     * @param reader
     * @return Object
     */
    public static Object unmarshalPv(Reader reader)
        throws MarshalException, ValidationException
    {
        return (auth_2_0.Pv) Unmarshaller.unmarshal(auth_2_0.Pv.class, reader);
    } //-- java.lang.Object unmarshalPv(java.io.Reader) 

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
