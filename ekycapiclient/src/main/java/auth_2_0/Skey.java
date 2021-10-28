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
 * Class Skey.
 * 
 * @version $Revision$ $Date$
 */
public class Skey implements Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * internal content storage
     */
    private byte[] _content;

    /**
     * Certificate identifier - should be expiry date of
     * certificate in YYYYMMDD format
     *  
     */
    private String _ci;

    /**
     * Unique key identifier
     *  
     */
    private String _ki;


      //----------------/
     //- Constructors -/
    //----------------/

    public Skey() 
     {
        super();
    } //-- auth_2_0.Skey()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Returns the value of field 'ci'. The field 'ci' has the
     * following description: Certificate identifier - should be
     * expiry date of certificate in YYYYMMDD format
     *  
     * 
     * @return String
     * @return the value of field 'ci'.
     */
    public String getCi()
    {
        return this._ci;
    } //-- java.lang.String getCi() 

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
     * Returns the value of field 'ki'. The field 'ki' has the
     * following description: Unique key identifier
     *  
     * 
     * @return String
     * @return the value of field 'ki'.
     */
    public String getKi()
    {
        return this._ki;
    } //-- java.lang.String getKi() 

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
     * Sets the value of field 'ci'. The field 'ci' has the
     * following description: Certificate identifier - should be
     * expiry date of certificate in YYYYMMDD format
     *  
     * 
     * @param ci the value of field 'ci'.
     */
    public void setCi(String ci)
    {
        this._ci = ci;
    } //-- void setCi(java.lang.String) 

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
     * Sets the value of field 'ki'. The field 'ki' has the
     * following description: Unique key identifier
     *  
     * 
     * @param ki the value of field 'ki'.
     */
    public void setKi(String ki)
    {
        this._ki = ki;
    } //-- void setKi(java.lang.String) 

    /**
     * Method unmarshalSkey
     * 
     * 
     * 
     * @param reader
     * @return Object
     */
    public static Object unmarshalSkey(Reader reader)
        throws MarshalException, ValidationException
    {
        return (auth_2_0.Skey) Unmarshaller.unmarshal(auth_2_0.Skey.class, reader);
    } //-- java.lang.Object unmarshalSkey(java.io.Reader) 

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
