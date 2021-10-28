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

import auth_2_0.types.BioMetricType;
import auth_2_0.types.BiometricPosition;
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
 * Base 64 encoded biometric record
 * 
 * @version $Revision$ $Date$
 */
public class Bio implements Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * internal content storage
     */
    private byte[] _content;

    /**
     * Field _type
     */
    private BioMetricType _type;

    /**
     * Biometric position hint
     */
    private BiometricPosition _posh;

    /**
     * generated bimetric signature
     */
    private String _bs;


      //----------------/
     //- Constructors -/
    //----------------/

    public Bio() 
     {
        super();
    } //-- auth_2_0.Bio()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Returns the value of field 'bs'. The field 'bs' has the
     * following description: generated bimetric signature
     * 
     * @return String
     * @return the value of field 'bs'.
     */
    public String getBs()
    {
        return this._bs;
    } //-- java.lang.String getBs() 

    /**
     * Returns the value of field 'content'. The field 'content'
     * has the following description: internal content storage
     * 
     * @return byte
     * @return the value of field 'content'.
     */
    public byte[] getContent()
    {
        return this._content;
    } //-- byte[] getContent() 

    /**
     * Returns the value of field 'posh'. The field 'posh' has the
     * following description: Biometric position hint
     * 
     * @return BiometricPosition
     * @return the value of field 'posh'.
     */
    public BiometricPosition getPosh()
    {
        return this._posh;
    } //-- auth_2_0.types.BiometricPosition getPosh() 

    /**
     * Returns the value of field 'type'.
     * 
     * @return BioMetricType
     * @return the value of field 'type'.
     */
    public BioMetricType getType()
    {
        return this._type;
    } //-- auth_2_0.types.BioMetricType getType() 

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
     * Sets the value of field 'bs'. The field 'bs' has the
     * following description: generated bimetric signature
     * 
     * @param bs the value of field 'bs'.
     */
    public void setBs(String bs)
    {
        this._bs = bs;
    } //-- void setBs(java.lang.String) 

    /**
     * Sets the value of field 'content'. The field 'content' has
     * the following description: internal content storage
     * 
     * @param content the value of field 'content'.
     */
    public void setContent(byte[] content)
    {
        this._content = content;
    } //-- void setContent(byte) 

    /**
     * Sets the value of field 'posh'. The field 'posh' has the
     * following description: Biometric position hint
     * 
     * @param posh the value of field 'posh'.
     */
    public void setPosh(BiometricPosition posh)
    {
        this._posh = posh;
    } //-- void setPosh(auth_2_0.types.BiometricPosition) 

    /**
     * Sets the value of field 'type'.
     * 
     * @param type the value of field 'type'.
     */
    public void setType(BioMetricType type)
    {
        this._type = type;
    } //-- void setType(auth_2_0.types.BioMetricType) 

    /**
     * Method unmarshalBio
     * 
     * 
     * 
     * @param reader
     * @return Object
     */
    public static Object unmarshalBio(Reader reader)
        throws MarshalException, ValidationException
    {
        return (auth_2_0.Bio) Unmarshaller.unmarshal(auth_2_0.Bio.class, reader);
    } //-- java.lang.Object unmarshalBio(java.io.Reader) 

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
