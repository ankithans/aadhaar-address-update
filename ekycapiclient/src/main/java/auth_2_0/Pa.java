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

import auth_2_0.types.MatchingStrategy;
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
 * Personal address data to be matched
 *  
 * 
 * @version $Revision$ $Date$
 */
public class Pa implements Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Matching strategy to be used for
     *  authentication purposes
     *  
     */
    private MatchingStrategy _ms = MatchingStrategy.valueOf("E");

    /**
     * Care of person's name
     */
    private String _co;

    /**
     * House identifier
     */
    private String _house;

    /**
     * Street name
     */
    private String _street;

    /**
     * Landmark if any
     */
    private String _lm;

    /**
     * Locality where resident resides
     *  
     */
    private String _loc;

    /**
     * Name of the village or town or city
     *  
     */
    private String _vtc;

    /**
     * PO Name
     *  
     */
    private String _po;

    /**
     * Sub district
     *  
     */
    private String _subdist;

    /**
     * District name
     */
    private String _dist;

    /**
     * State name
     */
    private String _state;

    /**
     * Postal pin code
     */
    private String _pc;

    /**
     * Country name
     */
    private String _country;


      //----------------/
     //- Constructors -/
    //----------------/

    public Pa() 
     {
        super();
        setMs(MatchingStrategy.valueOf("E"));
    } //-- auth_2_0.Pa()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Returns the value of field 'co'. The field 'co' has the
     * following description: Care of person's name
     * 
     * @return String
     * @return the value of field 'co'.
     */
    public String getCo()
    {
        return this._co;
    } //-- java.lang.String getCo() 

    /**
     * Returns the value of field 'country'. The field 'country'
     * has the following description: Country name
     * 
     * @return String
     * @return the value of field 'country'.
     */
    public String getCountry()
    {
        return this._country;
    } //-- java.lang.String getCountry() 

    /**
     * Returns the value of field 'dist'. The field 'dist' has the
     * following description: District name
     * 
     * @return String
     * @return the value of field 'dist'.
     */
    public String getDist()
    {
        return this._dist;
    } //-- java.lang.String getDist() 

    /**
     * Returns the value of field 'house'. The field 'house' has
     * the following description: House identifier
     * 
     * @return String
     * @return the value of field 'house'.
     */
    public String getHouse()
    {
        return this._house;
    } //-- java.lang.String getHouse() 

    /**
     * Returns the value of field 'lm'. The field 'lm' has the
     * following description: Landmark if any
     * 
     * @return String
     * @return the value of field 'lm'.
     */
    public String getLm()
    {
        return this._lm;
    } //-- java.lang.String getLm() 

    /**
     * Returns the value of field 'loc'. The field 'loc' has the
     * following description: Locality where resident resides
     *  
     * 
     * @return String
     * @return the value of field 'loc'.
     */
    public String getLoc()
    {
        return this._loc;
    } //-- java.lang.String getLoc() 

    /**
     * Returns the value of field 'ms'. The field 'ms' has the
     * following description: Matching strategy to be used for
     *  authentication purposes
     *  
     * 
     * @return MatchingStrategy
     * @return the value of field 'ms'.
     */
    public MatchingStrategy getMs()
    {
        return this._ms;
    } //-- auth_2_0.types.MatchingStrategy getMs() 

    /**
     * Returns the value of field 'pc'. The field 'pc' has the
     * following description: Postal pin code
     * 
     * @return String
     * @return the value of field 'pc'.
     */
    public String getPc()
    {
        return this._pc;
    } //-- java.lang.String getPc() 

    /**
     * Returns the value of field 'po'. The field 'po' has the
     * following description: PO Name
     *  
     * 
     * @return String
     * @return the value of field 'po'.
     */
    public String getPo()
    {
        return this._po;
    } //-- java.lang.String getPo() 

    /**
     * Returns the value of field 'state'. The field 'state' has
     * the following description: State name
     * 
     * @return String
     * @return the value of field 'state'.
     */
    public String getState()
    {
        return this._state;
    } //-- java.lang.String getState() 

    /**
     * Returns the value of field 'street'. The field 'street' has
     * the following description: Street name
     * 
     * @return String
     * @return the value of field 'street'.
     */
    public String getStreet()
    {
        return this._street;
    } //-- java.lang.String getStreet() 

    /**
     * Returns the value of field 'subdist'. The field 'subdist'
     * has the following description: Sub district
     *  
     * 
     * @return String
     * @return the value of field 'subdist'.
     */
    public String getSubdist()
    {
        return this._subdist;
    } //-- java.lang.String getSubdist() 

    /**
     * Returns the value of field 'vtc'. The field 'vtc' has the
     * following description: Name of the village or town or city
     *  
     * 
     * @return String
     * @return the value of field 'vtc'.
     */
    public String getVtc()
    {
        return this._vtc;
    } //-- java.lang.String getVtc() 

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
     * Sets the value of field 'co'. The field 'co' has the
     * following description: Care of person's name
     * 
     * @param co the value of field 'co'.
     */
    public void setCo(String co)
    {
        this._co = co;
    } //-- void setCo(java.lang.String) 

    /**
     * Sets the value of field 'country'. The field 'country' has
     * the following description: Country name
     * 
     * @param country the value of field 'country'.
     */
    public void setCountry(String country)
    {
        this._country = country;
    } //-- void setCountry(java.lang.String) 

    /**
     * Sets the value of field 'dist'. The field 'dist' has the
     * following description: District name
     * 
     * @param dist the value of field 'dist'.
     */
    public void setDist(String dist)
    {
        this._dist = dist;
    } //-- void setDist(java.lang.String) 

    /**
     * Sets the value of field 'house'. The field 'house' has the
     * following description: House identifier
     * 
     * @param house the value of field 'house'.
     */
    public void setHouse(String house)
    {
        this._house = house;
    } //-- void setHouse(java.lang.String) 

    /**
     * Sets the value of field 'lm'. The field 'lm' has the
     * following description: Landmark if any
     * 
     * @param lm the value of field 'lm'.
     */
    public void setLm(String lm)
    {
        this._lm = lm;
    } //-- void setLm(java.lang.String) 

    /**
     * Sets the value of field 'loc'. The field 'loc' has the
     * following description: Locality where resident resides
     *  
     * 
     * @param loc the value of field 'loc'.
     */
    public void setLoc(String loc)
    {
        this._loc = loc;
    } //-- void setLoc(java.lang.String) 

    /**
     * Sets the value of field 'ms'. The field 'ms' has the
     * following description: Matching strategy to be used for
     *  authentication purposes
     *  
     * 
     * @param ms the value of field 'ms'.
     */
    public void setMs(MatchingStrategy ms)
    {
        this._ms = ms;
    } //-- void setMs(auth_2_0.types.MatchingStrategy) 

    /**
     * Sets the value of field 'pc'. The field 'pc' has the
     * following description: Postal pin code
     * 
     * @param pc the value of field 'pc'.
     */
    public void setPc(String pc)
    {
        this._pc = pc;
    } //-- void setPc(java.lang.String) 

    /**
     * Sets the value of field 'po'. The field 'po' has the
     * following description: PO Name
     *  
     * 
     * @param po the value of field 'po'.
     */
    public void setPo(String po)
    {
        this._po = po;
    } //-- void setPo(java.lang.String) 

    /**
     * Sets the value of field 'state'. The field 'state' has the
     * following description: State name
     * 
     * @param state the value of field 'state'.
     */
    public void setState(String state)
    {
        this._state = state;
    } //-- void setState(java.lang.String) 

    /**
     * Sets the value of field 'street'. The field 'street' has the
     * following description: Street name
     * 
     * @param street the value of field 'street'.
     */
    public void setStreet(String street)
    {
        this._street = street;
    } //-- void setStreet(java.lang.String) 

    /**
     * Sets the value of field 'subdist'. The field 'subdist' has
     * the following description: Sub district
     *  
     * 
     * @param subdist the value of field 'subdist'.
     */
    public void setSubdist(String subdist)
    {
        this._subdist = subdist;
    } //-- void setSubdist(java.lang.String) 

    /**
     * Sets the value of field 'vtc'. The field 'vtc' has the
     * following description: Name of the village or town or city
     *  
     * 
     * @param vtc the value of field 'vtc'.
     */
    public void setVtc(String vtc)
    {
        this._vtc = vtc;
    } //-- void setVtc(java.lang.String) 

    /**
     * Method unmarshalPa
     * 
     * 
     * 
     * @param reader
     * @return Object
     */
    public static Object unmarshalPa(Reader reader)
        throws MarshalException, ValidationException
    {
        return (auth_2_0.Pa) Unmarshaller.unmarshal(auth_2_0.Pa.class, reader);
    } //-- java.lang.Object unmarshalPa(java.io.Reader) 

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
