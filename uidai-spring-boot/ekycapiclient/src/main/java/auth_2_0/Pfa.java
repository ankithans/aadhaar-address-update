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
 * Personal full address data to be matched
 *  
 * 
 * @version $Revision$ $Date$
 */
public class Pfa implements Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Match value is a value between 1 and 100,
     *  and it indicates percentage of full words that must match
     *  for authentication to be successful
     *  
     */
    private int _mv = 100;

    /**
     * keeps track of state for field: _mv
     */
    private boolean _has_mv;

    /**
     * Matching strategy to be used for
     *  for matching english address
     *  
     */
    private MatchingStrategy _ms = MatchingStrategy.valueOf("E");

    /**
     * Resident's full address specified as one
     *  string value
     *  
     */
    private String _av;

    /**
     * Local match value is a value between 1 and 100,
     *  and it indicates fuzziness threshold to be used when using
     * local address, lav
     *  
     */
    private int _lmv;

    /**
     * keeps track of state for field: _lmv
     */
    private boolean _has_lmv;

    /**
     * Resident's full address specified as one
     *  string value in local langauge
     *  
     */
    private String _lav;


      //----------------/
     //- Constructors -/
    //----------------/

    public Pfa() 
     {
        super();
        setMs(MatchingStrategy.valueOf("E"));
    } //-- auth_2_0.Pfa()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Method deleteLmv
     * 
     */
    public void deleteLmv()
    {
        this._has_lmv= false;
    } //-- void deleteLmv() 

    /**
     * Method deleteMv
     * 
     */
    public void deleteMv()
    {
        this._has_mv= false;
    } //-- void deleteMv() 

    /**
     * Returns the value of field 'av'. The field 'av' has the
     * following description: Resident's full address specified as
     * one
     *  string value
     *  
     * 
     * @return String
     * @return the value of field 'av'.
     */
    public String getAv()
    {
        return this._av;
    } //-- java.lang.String getAv() 

    /**
     * Returns the value of field 'lav'. The field 'lav' has the
     * following description: Resident's full address specified as
     * one
     *  string value in local langauge
     *  
     * 
     * @return String
     * @return the value of field 'lav'.
     */
    public String getLav()
    {
        return this._lav;
    } //-- java.lang.String getLav() 

    /**
     * Returns the value of field 'lmv'. The field 'lmv' has the
     * following description: Local match value is a value between
     * 1 and 100,
     *  and it indicates fuzziness threshold to be used when using
     * local address, lav
     *  
     * 
     * @return int
     * @return the value of field 'lmv'.
     */
    public int getLmv()
    {
        return this._lmv;
    } //-- int getLmv() 

    /**
     * Returns the value of field 'ms'. The field 'ms' has the
     * following description: Matching strategy to be used for
     *  for matching english address
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
     * Returns the value of field 'mv'. The field 'mv' has the
     * following description: Match value is a value between 1 and
     * 100,
     *  and it indicates percentage of full words that must match
     *  for authentication to be successful
     *  
     * 
     * @return int
     * @return the value of field 'mv'.
     */
    public int getMv()
    {
        return this._mv;
    } //-- int getMv() 

    /**
     * Method hasLmv
     * 
     * 
     * 
     * @return boolean
     */
    public boolean hasLmv()
    {
        return this._has_lmv;
    } //-- boolean hasLmv() 

    /**
     * Method hasMv
     * 
     * 
     * 
     * @return boolean
     */
    public boolean hasMv()
    {
        return this._has_mv;
    } //-- boolean hasMv() 

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
     * Sets the value of field 'av'. The field 'av' has the
     * following description: Resident's full address specified as
     * one
     *  string value
     *  
     * 
     * @param av the value of field 'av'.
     */
    public void setAv(String av)
    {
        this._av = av;
    } //-- void setAv(java.lang.String) 

    /**
     * Sets the value of field 'lav'. The field 'lav' has the
     * following description: Resident's full address specified as
     * one
     *  string value in local langauge
     *  
     * 
     * @param lav the value of field 'lav'.
     */
    public void setLav(String lav)
    {
        this._lav = lav;
    } //-- void setLav(java.lang.String) 

    /**
     * Sets the value of field 'lmv'. The field 'lmv' has the
     * following description: Local match value is a value between
     * 1 and 100,
     *  and it indicates fuzziness threshold to be used when using
     * local address, lav
     *  
     * 
     * @param lmv the value of field 'lmv'.
     */
    public void setLmv(int lmv)
    {
        this._lmv = lmv;
        this._has_lmv = true;
    } //-- void setLmv(int) 

    /**
     * Sets the value of field 'ms'. The field 'ms' has the
     * following description: Matching strategy to be used for
     *  for matching english address
     *  
     * 
     * @param ms the value of field 'ms'.
     */
    public void setMs(MatchingStrategy ms)
    {
        this._ms = ms;
    } //-- void setMs(auth_2_0.types.MatchingStrategy) 

    /**
     * Sets the value of field 'mv'. The field 'mv' has the
     * following description: Match value is a value between 1 and
     * 100,
     *  and it indicates percentage of full words that must match
     *  for authentication to be successful
     *  
     * 
     * @param mv the value of field 'mv'.
     */
    public void setMv(int mv)
    {
        this._mv = mv;
        this._has_mv = true;
    } //-- void setMv(int) 

    /**
     * Method unmarshalPfa
     * 
     * 
     * 
     * @param reader
     * @return Object
     */
    public static Object unmarshalPfa(Reader reader)
        throws MarshalException, ValidationException
    {
        return (auth_2_0.Pfa) Unmarshaller.unmarshal(auth_2_0.Pfa.class, reader);
    } //-- java.lang.Object unmarshalPfa(java.io.Reader) 

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
