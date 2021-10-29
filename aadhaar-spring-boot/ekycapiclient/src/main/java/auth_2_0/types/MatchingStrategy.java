/*
 * This class was automatically generated with 
 * <a href="http://www.castor.org">Castor 0.9.7</a>, using an XML
 * Schema.
 * $Id$
 */

package auth_2_0.types;

  //---------------------------------/
 //- Imported classes and packages -/
//---------------------------------/

import java.io.Serializable;
import java.util.Enumeration;
import java.util.Hashtable;
import org.exolab.castor.xml.Marshaller;
import org.exolab.castor.xml.Unmarshaller;

/**
 * Class MatchingStrategy.
 * 
 * @version $Revision$ $Date$
 */
public class MatchingStrategy implements Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * The E type
     */
    public static final int E_TYPE = 0;

    /**
     * The instance of the E type
     */
    public static final MatchingStrategy E = new MatchingStrategy(E_TYPE, "E");

    /**
     * The P type
     */
    public static final int P_TYPE = 1;

    /**
     * The instance of the P type
     */
    public static final MatchingStrategy P = new MatchingStrategy(P_TYPE, "P");

    /**
     * The F type
     */
    public static final int F_TYPE = 2;

    /**
     * The instance of the F type
     */
    public static final MatchingStrategy F = new MatchingStrategy(F_TYPE, "F");

    /**
     * The S type
     */
    public static final int S_TYPE = 3;

    /**
     * The instance of the S type
     */
    public static final MatchingStrategy S = new MatchingStrategy(S_TYPE, "S");

    /**
     * Field _memberTable
     */
    private static Hashtable _memberTable = init();

    /**
     * Field type
     */
    private int type = -1;

    /**
     * Field stringValue
     */
    private String stringValue = null;


      //----------------/
     //- Constructors -/
    //----------------/

    private MatchingStrategy(int type, String value)
     {
        super();
        this.type = type;
        this.stringValue = value;
    } //-- auth_2_0.types.MatchingStrategy(int, java.lang.String)


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Method enumerate
     * 
     * Returns an enumeration of all possible instances of
     * MatchingStrategy
     * 
     * @return Enumeration
     */
    public static Enumeration enumerate()
    {
        return _memberTable.elements();
    } //-- java.util.Enumeration enumerate() 

    /**
     * Method getType
     * 
     * Returns the type of this MatchingStrategy
     * 
     * @return int
     */
    public int getType()
    {
        return this.type;
    } //-- int getType() 

    /**
     * Method init
     * 
     * 
     * 
     * @return Hashtable
     */
    private static Hashtable init()
    {
        Hashtable members = new Hashtable();
        members.put("E", E);
        members.put("P", P);
        members.put("F", F);
        members.put("S", S);
        return members;
    } //-- java.util.Hashtable init() 

    /**
     * Method readResolve
     * 
     *  will be called during deserialization to replace the
     * deserialized object with the correct constant instance.
     * <br/>
     * 
     * @return Object
     */
    private Object readResolve()
    {
        return valueOf(this.stringValue);
    } //-- java.lang.Object readResolve() 

    /**
     * Method toString
     * 
     * Returns the String representation of this MatchingStrategy
     * 
     * @return String
     */
    public String toString()
    {
        return this.stringValue;
    } //-- java.lang.String toString() 

    /**
     * Method valueOf
     * 
     * Returns a new MatchingStrategy based on the given String
     * value.
     * 
     * @param string
     * @return MatchingStrategy
     */
    public static auth_2_0.types.MatchingStrategy valueOf(String string)
    {
        Object obj = null;
        if (string != null) obj = _memberTable.get(string);
        if (obj == null) {
            String err = "'" + string + "' is not a valid MatchingStrategy";
            throw new IllegalArgumentException(err);
        }
        return (MatchingStrategy) obj;
    } //-- auth_2_0.types.MatchingStrategy valueOf(java.lang.String) 

}
