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
 * Class UsesType.
 * 
 * @version $Revision$ $Date$
 */
public class UsesType implements Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * The y type
     */
    public static final int Y_TYPE = 0;

    /**
     * The instance of the y type
     */
    public static final UsesType Y = new UsesType(Y_TYPE, "y");

    /**
     * The n type
     */
    public static final int N_TYPE = 1;

    /**
     * The instance of the n type
     */
    public static final UsesType N = new UsesType(N_TYPE, "n");

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

    private UsesType(int type, String value)
     {
        super();
        this.type = type;
        this.stringValue = value;
    } //-- auth_2_0.types.UsesType(int, java.lang.String)


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Method enumerate
     * 
     * Returns an enumeration of all possible instances of UsesType
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
     * Returns the type of this UsesType
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
        members.put("y", Y);
        members.put("n", N);
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
     * Returns the String representation of this UsesType
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
     * Returns a new UsesType based on the given String value.
     * 
     * @param string
     * @return UsesType
     */
    public static UsesType valueOf(String string)
    {
        Object obj = null;
        if (string != null) obj = _memberTable.get(string);
        if (obj == null) {
            String err = "'" + string + "' is not a valid UsesType";
            throw new IllegalArgumentException(err);
        }
        return (UsesType) obj;
    } //-- auth_2_0.types.UsesType valueOf(java.lang.String) 

}
