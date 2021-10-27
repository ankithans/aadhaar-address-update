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
 * Demographic data to be matched
 *  
 * 
 * @version $Revision$ $Date$
 */
public class Demo implements Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _lang
     */
    private String _lang = "23";

    /**
     * Field _pi
     */
    private auth_2_0.Pi _pi;

    /**
     * Field _pa
     */
    private auth_2_0.Pa _pa;

    /**
     * Field _pfa
     */
    private auth_2_0.Pfa _pfa;


      //----------------/
     //- Constructors -/
    //----------------/

    public Demo() 
     {
        super();
        setLang("23");
    } //-- auth_2_0.Demo()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Returns the value of field 'lang'.
     * 
     * @return String
     * @return the value of field 'lang'.
     */
    public String getLang()
    {
        return this._lang;
    } //-- java.lang.String getLang() 

    /**
     * Returns the value of field 'pa'.
     * 
     * @return Pa
     * @return the value of field 'pa'.
     */
    public auth_2_0.Pa getPa()
    {
        return this._pa;
    } //-- auth_2_0.Pa getPa() 

    /**
     * Returns the value of field 'pfa'.
     * 
     * @return Pfa
     * @return the value of field 'pfa'.
     */
    public auth_2_0.Pfa getPfa()
    {
        return this._pfa;
    } //-- auth_2_0.Pfa getPfa() 

    /**
     * Returns the value of field 'pi'.
     * 
     * @return Pi
     * @return the value of field 'pi'.
     */
    public auth_2_0.Pi getPi()
    {
        return this._pi;
    } //-- auth_2_0.Pi getPi() 

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
     * Sets the value of field 'lang'.
     * 
     * @param lang the value of field 'lang'.
     */
    public void setLang(String lang)
    {
        this._lang = lang;
    } //-- void setLang(java.lang.String) 

    /**
     * Sets the value of field 'pa'.
     * 
     * @param pa the value of field 'pa'.
     */
    public void setPa(auth_2_0.Pa pa)
    {
        this._pa = pa;
    } //-- void setPa(auth_2_0.Pa) 

    /**
     * Sets the value of field 'pfa'.
     * 
     * @param pfa the value of field 'pfa'.
     */
    public void setPfa(auth_2_0.Pfa pfa)
    {
        this._pfa = pfa;
    } //-- void setPfa(auth_2_0.Pfa) 

    /**
     * Sets the value of field 'pi'.
     * 
     * @param pi the value of field 'pi'.
     */
    public void setPi(auth_2_0.Pi pi)
    {
        this._pi = pi;
    } //-- void setPi(auth_2_0.Pi) 

    /**
     * Method unmarshalDemo
     * 
     * 
     * 
     * @param reader
     * @return Object
     */
    public static Object unmarshalDemo(Reader reader)
        throws MarshalException, ValidationException
    {
        return (auth_2_0.Demo) Unmarshaller.unmarshal(auth_2_0.Demo.class, reader);
    } //-- java.lang.Object unmarshalDemo(java.io.Reader) 

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
