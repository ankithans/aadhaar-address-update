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
import org.exolab.castor.xml.MarshalException;
import org.exolab.castor.xml.Marshaller;
import org.exolab.castor.xml.Unmarshaller;
import org.exolab.castor.xml.ValidationException;
import org.xml.sax.ContentHandler;

/**
 * Person Identification Data
 * 
 * @version $Revision$ $Date$
 */
public class Pid implements Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Timestamp of capture
     *  
     */
    private Date _ts;

    /**
     * Version of the API. Defaulted to latest
     *  version
     *  
     */
    private String _ver = "2.0";

    /**
     * Wrapper API data hash.Defaulted empty.
     *  
     */
    private String _wadh;

    /**
     * Demographic
     *  Data for Matching
     *  
     */
    private auth_2_0.Demo _demo;

    /**
     * Biometric Data
     *  for Matching
     *  
     */
    private auth_2_0.Bios _bios;

    /**
     * Additional
     *  secret pin or otp or
     *  both for supporting multifactor authentication
     *  
     */
    private auth_2_0.Pv _pv;


      //----------------/
     //- Constructors -/
    //----------------/

    public Pid() 
     {
        super();
        setVer("2.0");
    } //-- auth_2_0.Pid()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Returns the value of field 'bios'. The field 'bios' has the
     * following description: Biometric Data
     *  for Matching
     *  
     * 
     * @return Bios
     * @return the value of field 'bios'.
     */
    public auth_2_0.Bios getBios()
    {
        return this._bios;
    } //-- auth_2_0.Bios getBios() 

    /**
     * Returns the value of field 'demo'. The field 'demo' has the
     * following description: Demographic
     *  Data for Matching
     *  
     * 
     * @return Demo
     * @return the value of field 'demo'.
     */
    public auth_2_0.Demo getDemo()
    {
        return this._demo;
    } //-- auth_2_0.Demo getDemo() 

    /**
     * Returns the value of field 'pv'. The field 'pv' has the
     * following description: Additional
     *  secret pin or otp or
     *  both for supporting multifactor authentication
     *  
     * 
     * @return Pv
     * @return the value of field 'pv'.
     */
    public auth_2_0.Pv getPv()
    {
        return this._pv;
    } //-- auth_2_0.Pv getPv() 

    /**
     * Returns the value of field 'ts'. The field 'ts' has the
     * following description: Timestamp of capture
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
     * Returns the value of field 'wadh'. The field 'wadh' has the
     * following description: Wrapper API data hash.Defaulted
     * empty.
     *  
     * 
     * @return String
     * @return the value of field 'wadh'.
     */
    public String getWadh()
    {
        return this._wadh;
    } //-- java.lang.String getWadh() 

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
     * Sets the value of field 'bios'. The field 'bios' has the
     * following description: Biometric Data
     *  for Matching
     *  
     * 
     * @param bios the value of field 'bios'.
     */
    public void setBios(auth_2_0.Bios bios)
    {
        this._bios = bios;
    } //-- void setBios(auth_2_0.Bios) 

    /**
     * Sets the value of field 'demo'. The field 'demo' has the
     * following description: Demographic
     *  Data for Matching
     *  
     * 
     * @param demo the value of field 'demo'.
     */
    public void setDemo(auth_2_0.Demo demo)
    {
        this._demo = demo;
    } //-- void setDemo(auth_2_0.Demo) 

    /**
     * Sets the value of field 'pv'. The field 'pv' has the
     * following description: Additional
     *  secret pin or otp or
     *  both for supporting multifactor authentication
     *  
     * 
     * @param pv the value of field 'pv'.
     */
    public void setPv(auth_2_0.Pv pv)
    {
        this._pv = pv;
    } //-- void setPv(auth_2_0.Pv) 

    /**
     * Sets the value of field 'ts'. The field 'ts' has the
     * following description: Timestamp of capture
     *  
     * 
     * @param ts the value of field 'ts'.
     */
    public void setTs(Date ts)
    {
        this._ts = ts;
    } //-- void setTs(java.util.Date) 

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
     * Sets the value of field 'wadh'. The field 'wadh' has the
     * following description: Wrapper API data hash.Defaulted
     * empty.
     *  
     * 
     * @param wadh the value of field 'wadh'.
     */
    public void setWadh(String wadh)
    {
        this._wadh = wadh;
    } //-- void setWadh(java.lang.String) 

    /**
     * Method unmarshalPid
     * 
     * 
     * 
     * @param reader
     * @return Object
     */
    public static Object unmarshalPid(Reader reader)
        throws MarshalException, ValidationException
    {
        return (auth_2_0.Pid) Unmarshaller.unmarshal(auth_2_0.Pid.class, reader);
    } //-- java.lang.Object unmarshalPid(java.io.Reader) 

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
