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

import auth_2_0.types.Gender;
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
 * Personal identity data to be matched
 * 
 * @version $Revision$ $Date$
 */
public class Pi implements Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Matching strategy to be used for English name matching
     */
    private MatchingStrategy _ms = MatchingStrategy.valueOf("E");

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
     * Name of the resident
     */
    private String _name;

    /**
     * Local match value is a value between 1 and 100,
     *  and it indicates fuzziness threshold to be applied only for
     * lname matching.
     *  
     */
    private int _lmv;

    /**
     * keeps track of state for field: _lmv
     */
    private boolean _has_lmv;

    /**
     * Name of the resident in local language
     */
    private String _lname;

    /**
     * Gender of the resident
     */
    private Gender _gender;

    /**
     * Date of birth of the resident
     *  
     */
    private String _dob;

    /**
     * Date of birth Type. Can be "A" (), "D" (Declared) or "V"
     * (Verified)
     *  
     */
    private String _dobt;

    /**
     * Date of birth of the resident
     *  
     */
    private int _age;

    /**
     * keeps track of state for field: _age
     */
    private boolean _has_age;

    /**
     * Phone number of the resident
     *  
     */
    private String _phone;

    /**
     * Email address of the resident
     *  
     */
    private String _email;


      //----------------/
     //- Constructors -/
    //----------------/

    public Pi() 
     {
        super();
        setMs(MatchingStrategy.valueOf("E"));
    } //-- auth_2_0.Pi()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Method deleteAge
     * 
     */
    public void deleteAge()
    {
        this._has_age= false;
    } //-- void deleteAge() 

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
     * Returns the value of field 'age'. The field 'age' has the
     * following description: Date of birth of the resident
     *  
     * 
     * @return int
     * @return the value of field 'age'.
     */
    public int getAge()
    {
        return this._age;
    } //-- int getAge() 

    /**
     * Returns the value of field 'dob'. The field 'dob' has the
     * following description: Date of birth of the resident
     *  
     * 
     * @return String
     * @return the value of field 'dob'.
     */
    public String getDob()
    {
        return this._dob;
    } //-- java.lang.String getDob() 

    /**
     * Returns the value of field 'dobt'. The field 'dobt' has the
     * following description: Date of birth Type. Can be "A" (),
     * "D" (Declared) or "V" (Verified)
     *  
     * 
     * @return String
     * @return the value of field 'dobt'.
     */
    public String getDobt()
    {
        return this._dobt;
    } //-- java.lang.String getDobt() 

    /**
     * Returns the value of field 'email'. The field 'email' has
     * the following description: Email address of the resident
     *  
     * 
     * @return String
     * @return the value of field 'email'.
     */
    public String getEmail()
    {
        return this._email;
    } //-- java.lang.String getEmail() 

    /**
     * Returns the value of field 'gender'. The field 'gender' has
     * the following description: Gender of the resident
     * 
     * @return Gender
     * @return the value of field 'gender'.
     */
    public Gender getGender()
    {
        return this._gender;
    } //-- auth_2_0.types.Gender getGender() 

    /**
     * Returns the value of field 'lmv'. The field 'lmv' has the
     * following description: Local match value is a value between
     * 1 and 100,
     *  and it indicates fuzziness threshold to be applied only for
     * lname matching.
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
     * Returns the value of field 'lname'. The field 'lname' has
     * the following description: Name of the resident in local
     * language
     * 
     * @return String
     * @return the value of field 'lname'.
     */
    public String getLname()
    {
        return this._lname;
    } //-- java.lang.String getLname() 

    /**
     * Returns the value of field 'ms'. The field 'ms' has the
     * following description: Matching strategy to be used for
     * English name matching
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
     * Returns the value of field 'name'. The field 'name' has the
     * following description: Name of the resident
     * 
     * @return String
     * @return the value of field 'name'.
     */
    public String getName()
    {
        return this._name;
    } //-- java.lang.String getName() 

    /**
     * Returns the value of field 'phone'. The field 'phone' has
     * the following description: Phone number of the resident
     *  
     * 
     * @return String
     * @return the value of field 'phone'.
     */
    public String getPhone()
    {
        return this._phone;
    } //-- java.lang.String getPhone() 

    /**
     * Method hasAge
     * 
     * 
     * 
     * @return boolean
     */
    public boolean hasAge()
    {
        return this._has_age;
    } //-- boolean hasAge() 

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
     * Sets the value of field 'age'. The field 'age' has the
     * following description: Date of birth of the resident
     *  
     * 
     * @param age the value of field 'age'.
     */
    public void setAge(int age)
    {
        this._age = age;
        this._has_age = true;
    } //-- void setAge(int) 

    /**
     * Sets the value of field 'dob'. The field 'dob' has the
     * following description: Date of birth of the resident
     *  
     * 
     * @param dob the value of field 'dob'.
     */
    public void setDob(String dob)
    {
        this._dob = dob;
    } //-- void setDob(java.lang.String) 

    /**
     * Sets the value of field 'dobt'. The field 'dobt' has the
     * following description: Date of birth Type. Can be "A" (),
     * "D" (Declared) or "V" (Verified)
     *  
     * 
     * @param dobt the value of field 'dobt'.
     */
    public void setDobt(String dobt)
    {
        this._dobt = dobt;
    } //-- void setDobt(java.lang.String) 

    /**
     * Sets the value of field 'email'. The field 'email' has the
     * following description: Email address of the resident
     *  
     * 
     * @param email the value of field 'email'.
     */
    public void setEmail(String email)
    {
        this._email = email;
    } //-- void setEmail(java.lang.String) 

    /**
     * Sets the value of field 'gender'. The field 'gender' has the
     * following description: Gender of the resident
     * 
     * @param gender the value of field 'gender'.
     */
    public void setGender(Gender gender)
    {
        this._gender = gender;
    } //-- void setGender(auth_2_0.types.Gender) 

    /**
     * Sets the value of field 'lmv'. The field 'lmv' has the
     * following description: Local match value is a value between
     * 1 and 100,
     *  and it indicates fuzziness threshold to be applied only for
     * lname matching.
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
     * Sets the value of field 'lname'. The field 'lname' has the
     * following description: Name of the resident in local
     * language
     * 
     * @param lname the value of field 'lname'.
     */
    public void setLname(String lname)
    {
        this._lname = lname;
    } //-- void setLname(java.lang.String) 

    /**
     * Sets the value of field 'ms'. The field 'ms' has the
     * following description: Matching strategy to be used for
     * English name matching
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
     * Sets the value of field 'name'. The field 'name' has the
     * following description: Name of the resident
     * 
     * @param name the value of field 'name'.
     */
    public void setName(String name)
    {
        this._name = name;
    } //-- void setName(java.lang.String) 

    /**
     * Sets the value of field 'phone'. The field 'phone' has the
     * following description: Phone number of the resident
     *  
     * 
     * @param phone the value of field 'phone'.
     */
    public void setPhone(String phone)
    {
        this._phone = phone;
    } //-- void setPhone(java.lang.String) 

    /**
     * Method unmarshalPi
     * 
     * 
     * 
     * @param reader
     * @return Object
     */
    public static Object unmarshalPi(Reader reader)
        throws MarshalException, ValidationException
    {
        return (auth_2_0.Pi) Unmarshaller.unmarshal(auth_2_0.Pi.class, reader);
    } //-- java.lang.Object unmarshalPi(java.io.Reader) 

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
