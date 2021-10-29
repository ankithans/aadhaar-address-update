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
 * Class Meta.
 * 
 * @version $Revision$ $Date$
 */
public class Meta implements Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _udc
     */
    private String _udc;

    /**
     * Field _rdsId
     */
    private String _rdsId;

    /**
     * Field _rdsVer
     */
    private String _rdsVer;

    /**
     * Field _dpId
     */
    private String _dpId;

    /**
     * Field _dc
     */
    private String _dc;

    /**
     * Field _mi
     */
    private String _mi;

    /**
     * Field _mc
     */
    private String _mc;


      //----------------/
     //- Constructors -/
    //----------------/

    public Meta() 
     {
        super();
    } //-- auth_2_0.Meta()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Returns the value of field 'dc'.
     * 
     * @return String
     * @return the value of field 'dc'.
     */
    public String getDc()
    {
        return this._dc;
    } //-- java.lang.String getDc() 

    /**
     * Returns the value of field 'dpId'.
     * 
     * @return String
     * @return the value of field 'dpId'.
     */
    public String getDpId()
    {
        return this._dpId;
    } //-- java.lang.String getDpId() 

    /**
     * Returns the value of field 'mc'.
     * 
     * @return String
     * @return the value of field 'mc'.
     */
    public String getMc()
    {
        return this._mc;
    } //-- java.lang.String getMc() 

    /**
     * Returns the value of field 'mi'.
     * 
     * @return String
     * @return the value of field 'mi'.
     */
    public String getMi()
    {
        return this._mi;
    } //-- java.lang.String getMi() 

    /**
     * Returns the value of field 'rdsId'.
     * 
     * @return String
     * @return the value of field 'rdsId'.
     */
    public String getRdsId()
    {
        return this._rdsId;
    } //-- java.lang.String getRdsId() 

    /**
     * Returns the value of field 'rdsVer'.
     * 
     * @return String
     * @return the value of field 'rdsVer'.
     */
    public String getRdsVer()
    {
        return this._rdsVer;
    } //-- java.lang.String getRdsVer() 

    /**
     * Returns the value of field 'udc'.
     * 
     * @return String
     * @return the value of field 'udc'.
     */
    public String getUdc()
    {
        return this._udc;
    } //-- java.lang.String getUdc() 

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
     * Sets the value of field 'dc'.
     * 
     * @param dc the value of field 'dc'.
     */
    public void setDc(String dc)
    {
        this._dc = dc;
    } //-- void setDc(java.lang.String) 

    /**
     * Sets the value of field 'dpId'.
     * 
     * @param dpId the value of field 'dpId'.
     */
    public void setDpId(String dpId)
    {
        this._dpId = dpId;
    } //-- void setDpId(java.lang.String) 

    /**
     * Sets the value of field 'mc'.
     * 
     * @param mc the value of field 'mc'.
     */
    public void setMc(String mc)
    {
        this._mc = mc;
    } //-- void setMc(java.lang.String) 

    /**
     * Sets the value of field 'mi'.
     * 
     * @param mi the value of field 'mi'.
     */
    public void setMi(String mi)
    {
        this._mi = mi;
    } //-- void setMi(java.lang.String) 

    /**
     * Sets the value of field 'rdsId'.
     * 
     * @param rdsId the value of field 'rdsId'.
     */
    public void setRdsId(String rdsId)
    {
        this._rdsId = rdsId;
    } //-- void setRdsId(java.lang.String) 

    /**
     * Sets the value of field 'rdsVer'.
     * 
     * @param rdsVer the value of field 'rdsVer'.
     */
    public void setRdsVer(String rdsVer)
    {
        this._rdsVer = rdsVer;
    } //-- void setRdsVer(java.lang.String) 

    /**
     * Sets the value of field 'udc'.
     * 
     * @param udc the value of field 'udc'.
     */
    public void setUdc(String udc)
    {
        this._udc = udc;
    } //-- void setUdc(java.lang.String) 

    /**
     * Method unmarshalMeta
     * 
     * 
     * 
     * @param reader
     * @return Object
     */
    public static Object unmarshalMeta(Reader reader)
        throws MarshalException, ValidationException
    {
        return (auth_2_0.Meta) Unmarshaller.unmarshal(auth_2_0.Meta.class, reader);
    } //-- java.lang.Object unmarshalMeta(java.io.Reader) 

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
