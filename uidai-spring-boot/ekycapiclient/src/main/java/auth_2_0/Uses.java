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

import auth_2_0.types.UsesType;
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
 * Class Uses.
 * 
 * @version $Revision$ $Date$
 */
public class Uses implements Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Indicates whether server should ensure
     *  presence of
     *  pi element
     *  
     */
    private UsesType _pi;

    /**
     * Indicates whether server should ensure
     *  presence of
     *  pa element
     *  
     */
    private UsesType _pa;

    /**
     * Indicates whether server should ensure
     *  presence of pfa element
     *  
     */
    private UsesType _pfa;

    /**
     * Indicates whether server should ensure for
     *  presence of bios and bio elements
     *  
     */
    private UsesType _bio;

    /**
     * Comma separated list of biometrics used. Valid
     *  values that can be used in this comma separated list are
     * “FMR”,
     *  “FIR”, and “IIR”.
     *  When specified, server will ensure presence of
     *  bio
     *  element of specified types.
     *  
     */
    private String _bt;

    /**
     * Field _pin
     */
    private UsesType _pin;

    /**
     * Indicates whether server should ensure
     *  presence of
     *  otp attribute in Pv element
     *  
     */
    private UsesType _otp;


      //----------------/
     //- Constructors -/
    //----------------/

    public Uses() 
     {
        super();
    } //-- auth_2_0.Uses()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Returns the value of field 'bio'. The field 'bio' has the
     * following description: Indicates whether server should
     * ensure for
     *  presence of bios and bio elements
     *  
     * 
     * @return UsesType
     * @return the value of field 'bio'.
     */
    public UsesType getBio()
    {
        return this._bio;
    } //-- auth_2_0.types.UsesType getBio() 

    /**
     * Returns the value of field 'bt'. The field 'bt' has the
     * following description: Comma separated list of biometrics
     * used. Valid
     *  values that can be used in this comma separated list are
     * “FMR”,
     *  “FIR”, and “IIR”.
     *  When specified, server will ensure presence of
     *  bio
     *  element of specified types.
     *  
     * 
     * @return String
     * @return the value of field 'bt'.
     */
    public String getBt()
    {
        return this._bt;
    } //-- java.lang.String getBt() 

    /**
     * Returns the value of field 'otp'. The field 'otp' has the
     * following description: Indicates whether server should
     * ensure
     *  presence of
     *  otp attribute in Pv element
     *  
     * 
     * @return UsesType
     * @return the value of field 'otp'.
     */
    public UsesType getOtp()
    {
        return this._otp;
    } //-- auth_2_0.types.UsesType getOtp() 

    /**
     * Returns the value of field 'pa'. The field 'pa' has the
     * following description: Indicates whether server should
     * ensure
     *  presence of
     *  pa element
     *  
     * 
     * @return UsesType
     * @return the value of field 'pa'.
     */
    public UsesType getPa()
    {
        return this._pa;
    } //-- auth_2_0.types.UsesType getPa() 

    /**
     * Returns the value of field 'pfa'. The field 'pfa' has the
     * following description: Indicates whether server should
     * ensure
     *  presence of pfa element
     *  
     * 
     * @return UsesType
     * @return the value of field 'pfa'.
     */
    public UsesType getPfa()
    {
        return this._pfa;
    } //-- auth_2_0.types.UsesType getPfa() 

    /**
     * Returns the value of field 'pi'. The field 'pi' has the
     * following description: Indicates whether server should
     * ensure
     *  presence of
     *  pi element
     *  
     * 
     * @return UsesType
     * @return the value of field 'pi'.
     */
    public UsesType getPi()
    {
        return this._pi;
    } //-- auth_2_0.types.UsesType getPi() 

    /**
     * Returns the value of field 'pin'.
     * 
     * @return UsesType
     * @return the value of field 'pin'.
     */
    public UsesType getPin()
    {
        return this._pin;
    } //-- auth_2_0.types.UsesType getPin() 

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
     * Sets the value of field 'bio'. The field 'bio' has the
     * following description: Indicates whether server should
     * ensure for
     *  presence of bios and bio elements
     *  
     * 
     * @param bio the value of field 'bio'.
     */
    public void setBio(UsesType bio)
    {
        this._bio = bio;
    } //-- void setBio(auth_2_0.types.UsesType) 

    /**
     * Sets the value of field 'bt'. The field 'bt' has the
     * following description: Comma separated list of biometrics
     * used. Valid
     *  values that can be used in this comma separated list are
     * “FMR”,
     *  “FIR”, and “IIR”.
     *  When specified, server will ensure presence of
     *  bio
     *  element of specified types.
     *  
     * 
     * @param bt the value of field 'bt'.
     */
    public void setBt(String bt)
    {
        this._bt = bt;
    } //-- void setBt(java.lang.String) 

    /**
     * Sets the value of field 'otp'. The field 'otp' has the
     * following description: Indicates whether server should
     * ensure
     *  presence of
     *  otp attribute in Pv element
     *  
     * 
     * @param otp the value of field 'otp'.
     */
    public void setOtp(UsesType otp)
    {
        this._otp = otp;
    } //-- void setOtp(auth_2_0.types.UsesType) 

    /**
     * Sets the value of field 'pa'. The field 'pa' has the
     * following description: Indicates whether server should
     * ensure
     *  presence of
     *  pa element
     *  
     * 
     * @param pa the value of field 'pa'.
     */
    public void setPa(UsesType pa)
    {
        this._pa = pa;
    } //-- void setPa(auth_2_0.types.UsesType) 

    /**
     * Sets the value of field 'pfa'. The field 'pfa' has the
     * following description: Indicates whether server should
     * ensure
     *  presence of pfa element
     *  
     * 
     * @param pfa the value of field 'pfa'.
     */
    public void setPfa(UsesType pfa)
    {
        this._pfa = pfa;
    } //-- void setPfa(auth_2_0.types.UsesType) 

    /**
     * Sets the value of field 'pi'. The field 'pi' has the
     * following description: Indicates whether server should
     * ensure
     *  presence of
     *  pi element
     *  
     * 
     * @param pi the value of field 'pi'.
     */
    public void setPi(UsesType pi)
    {
        this._pi = pi;
    } //-- void setPi(auth_2_0.types.UsesType) 

    /**
     * Sets the value of field 'pin'.
     * 
     * @param pin the value of field 'pin'.
     */
    public void setPin(UsesType pin)
    {
        this._pin = pin;
    } //-- void setPin(auth_2_0.types.UsesType) 

    /**
     * Method unmarshalUses
     * 
     * 
     * 
     * @param reader
     * @return Object
     */
    public static Object unmarshalUses(Reader reader)
        throws MarshalException, ValidationException
    {
        return (auth_2_0.Uses) Unmarshaller.unmarshal(auth_2_0.Uses.class, reader);
    } //-- java.lang.Object unmarshalUses(java.io.Reader) 

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
