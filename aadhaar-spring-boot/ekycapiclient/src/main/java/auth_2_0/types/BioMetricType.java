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
 * Biometric record type
 *  
 * 
 * @version $Revision$ $Date$
 */
public class BioMetricType implements Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * The FMR type
     */
    public static final int FMR_TYPE = 0;

    /**
     * The instance of the FMR type
     */
    public static final BioMetricType FMR = new BioMetricType(FMR_TYPE, "FMR");

    /**
     * The FIR type
     */
    public static final int FIR_TYPE = 1;

    /**
     * The instance of the FIR type
     */
    public static final BioMetricType FIR = new BioMetricType(FIR_TYPE, "FIR");

    /**
     * The IIR type
     */
    public static final int IIR_TYPE = 2;

    /**
     * The instance of the IIR type
     */
    public static final BioMetricType IIR = new BioMetricType(IIR_TYPE, "IIR");

    /**
     * The FID type
     */
    public static final int FID_TYPE = 3;

    /**
     * The instance of the FID type
     */
    public static final BioMetricType FID = new BioMetricType(FID_TYPE, "FID");

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

    private BioMetricType(int type, String value)
     {
        super();
        this.type = type;
        this.stringValue = value;
    } //-- auth_2_0.types.BioMetricType(int, java.lang.String)


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Method enumerate
     * 
     * Returns an enumeration of all possible instances of
     * BioMetricType
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
     * Returns the type of this BioMetricType
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
        members.put("FMR", FMR);
        members.put("FIR", FIR);
        members.put("IIR", IIR);
        members.put("FID", FID);
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
     * Returns the String representation of this BioMetricType
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
     * Returns a new BioMetricType based on the given String value.
     * 
     * @param string
     * @return BioMetricType
     */
    public static auth_2_0.types.BioMetricType valueOf(String string)
    {
        Object obj = null;
        if (string != null) obj = _memberTable.get(string);
        if (obj == null) {
            String err = "'" + string + "' is not a valid BioMetricType";
            throw new IllegalArgumentException(err);
        }
        return (BioMetricType) obj;
    } //-- auth_2_0.types.BioMetricType valueOf(java.lang.String) 

}
