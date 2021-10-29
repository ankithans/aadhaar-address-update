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

import auth_2_0.types.DataFormat;
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
 * Class Data.
 * 
 * @version $Revision$ $Date$
 */
public class Data implements Serializable {


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
    private DataFormat _type = DataFormat.valueOf("X");


      //----------------/
     //- Constructors -/
    //----------------/

    public Data() 
     {
        super();
        setType(DataFormat.valueOf("X"));
    } //-- auth_2_0.Data()


      //-----------/
     //- Methods -/
    //-----------/

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
     * Returns the value of field 'type'.
     * 
     * @return DataFormat
     * @return the value of field 'type'.
     */
    public DataFormat getType()
    {
        return this._type;
    } //-- auth_2_0.types.DataFormat getType() 

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
     * Sets the value of field 'type'.
     * 
     * @param type the value of field 'type'.
     */
    public void setType(DataFormat type)
    {
        this._type = type;
    } //-- void setType(auth_2_0.types.DataFormat) 

    /**
     * Method unmarshalData
     * 
     * 
     * 
     * @param reader
     * @return Object
     */
    public static Object unmarshalData(Reader reader)
        throws MarshalException, ValidationException
    {
        return (auth_2_0.Data) Unmarshaller.unmarshal(auth_2_0.Data.class, reader);
    } //-- java.lang.Object unmarshalData(java.io.Reader) 

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
