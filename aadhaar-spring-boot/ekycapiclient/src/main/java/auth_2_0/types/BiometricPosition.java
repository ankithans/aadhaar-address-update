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
 * Additional attribute added for pos
 *  
 * 
 * @version $Revision$ $Date$
 */
public class BiometricPosition implements Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * The LEFT_IRIS type
     */
    public static final int LEFT_IRIS_TYPE = 0;

    /**
     * The instance of the LEFT_IRIS type
     */
    public static final BiometricPosition LEFT_IRIS = new BiometricPosition(LEFT_IRIS_TYPE, "LEFT_IRIS");

    /**
     * The RIGHT_IRIS type
     */
    public static final int RIGHT_IRIS_TYPE = 1;

    /**
     * The instance of the RIGHT_IRIS type
     */
    public static final BiometricPosition RIGHT_IRIS = new BiometricPosition(RIGHT_IRIS_TYPE, "RIGHT_IRIS");

    /**
     * The BOTH_IRIS type
     */
    public static final int BOTH_IRIS_TYPE = 2;

    /**
     * The instance of the BOTH_IRIS type
     */
    public static final BiometricPosition BOTH_IRIS = new BiometricPosition(BOTH_IRIS_TYPE, "BOTH_IRIS");

    /**
     * The LEFT_INDEX type
     */
    public static final int LEFT_INDEX_TYPE = 3;

    /**
     * The instance of the LEFT_INDEX type
     */
    public static final BiometricPosition LEFT_INDEX = new BiometricPosition(LEFT_INDEX_TYPE, "LEFT_INDEX");

    /**
     * The LEFT_LITTLE type
     */
    public static final int LEFT_LITTLE_TYPE = 4;

    /**
     * The instance of the LEFT_LITTLE type
     */
    public static final BiometricPosition LEFT_LITTLE = new BiometricPosition(LEFT_LITTLE_TYPE, "LEFT_LITTLE");

    /**
     * The LEFT_MIDDLE type
     */
    public static final int LEFT_MIDDLE_TYPE = 5;

    /**
     * The instance of the LEFT_MIDDLE type
     */
    public static final BiometricPosition LEFT_MIDDLE = new BiometricPosition(LEFT_MIDDLE_TYPE, "LEFT_MIDDLE");

    /**
     * The LEFT_RING type
     */
    public static final int LEFT_RING_TYPE = 6;

    /**
     * The instance of the LEFT_RING type
     */
    public static final BiometricPosition LEFT_RING = new BiometricPosition(LEFT_RING_TYPE, "LEFT_RING");

    /**
     * The LEFT_THUMB type
     */
    public static final int LEFT_THUMB_TYPE = 7;

    /**
     * The instance of the LEFT_THUMB type
     */
    public static final BiometricPosition LEFT_THUMB = new BiometricPosition(LEFT_THUMB_TYPE, "LEFT_THUMB");

    /**
     * The RIGHT_INDEX type
     */
    public static final int RIGHT_INDEX_TYPE = 8;

    /**
     * The instance of the RIGHT_INDEX type
     */
    public static final BiometricPosition RIGHT_INDEX = new BiometricPosition(RIGHT_INDEX_TYPE, "RIGHT_INDEX");

    /**
     * The RIGHT_LITTLE type
     */
    public static final int RIGHT_LITTLE_TYPE = 9;

    /**
     * The instance of the RIGHT_LITTLE type
     */
    public static final BiometricPosition RIGHT_LITTLE = new BiometricPosition(RIGHT_LITTLE_TYPE, "RIGHT_LITTLE");

    /**
     * The RIGHT_MIDDLE type
     */
    public static final int RIGHT_MIDDLE_TYPE = 10;

    /**
     * The instance of the RIGHT_MIDDLE type
     */
    public static final BiometricPosition RIGHT_MIDDLE = new BiometricPosition(RIGHT_MIDDLE_TYPE, "RIGHT_MIDDLE");

    /**
     * The RIGHT_RING type
     */
    public static final int RIGHT_RING_TYPE = 11;

    /**
     * The instance of the RIGHT_RING type
     */
    public static final BiometricPosition RIGHT_RING = new BiometricPosition(RIGHT_RING_TYPE, "RIGHT_RING");

    /**
     * The RIGHT_THUMB type
     */
    public static final int RIGHT_THUMB_TYPE = 12;

    /**
     * The instance of the RIGHT_THUMB type
     */
    public static final BiometricPosition RIGHT_THUMB = new BiometricPosition(RIGHT_THUMB_TYPE, "RIGHT_THUMB");

    /**
     * The BOTH_THUMBS type
     */
    public static final int BOTH_THUMBS_TYPE = 13;

    /**
     * The instance of the BOTH_THUMBS type
     */
    public static final BiometricPosition BOTH_THUMBS = new BiometricPosition(BOTH_THUMBS_TYPE, "BOTH_THUMBS");

    /**
     * The LEFT_SLAP type
     */
    public static final int LEFT_SLAP_TYPE = 14;

    /**
     * The instance of the LEFT_SLAP type
     */
    public static final BiometricPosition LEFT_SLAP = new BiometricPosition(LEFT_SLAP_TYPE, "LEFT_SLAP");

    /**
     * The RIGHT_SLAP type
     */
    public static final int RIGHT_SLAP_TYPE = 15;

    /**
     * The instance of the RIGHT_SLAP type
     */
    public static final BiometricPosition RIGHT_SLAP = new BiometricPosition(RIGHT_SLAP_TYPE, "RIGHT_SLAP");

    /**
     * The FACE type
     */
    public static final int FACE_TYPE = 16;

    /**
     * The instance of the FACE type
     */
    public static final BiometricPosition FACE = new BiometricPosition(FACE_TYPE, "FACE");

    /**
     * The UNKNOWN type
     */
    public static final int UNKNOWN_TYPE = 17;

    /**
     * The instance of the UNKNOWN type
     */
    public static final BiometricPosition UNKNOWN = new BiometricPosition(UNKNOWN_TYPE, "UNKNOWN");

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

    private BiometricPosition(int type, String value)
     {
        super();
        this.type = type;
        this.stringValue = value;
    } //-- auth_2_0.types.BiometricPosition(int, java.lang.String)


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Method enumerate
     * 
     * Returns an enumeration of all possible instances of
     * BiometricPosition
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
     * Returns the type of this BiometricPosition
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
        members.put("LEFT_IRIS", LEFT_IRIS);
        members.put("RIGHT_IRIS", RIGHT_IRIS);
        members.put("BOTH_IRIS", BOTH_IRIS);
        members.put("LEFT_INDEX", LEFT_INDEX);
        members.put("LEFT_LITTLE", LEFT_LITTLE);
        members.put("LEFT_MIDDLE", LEFT_MIDDLE);
        members.put("LEFT_RING", LEFT_RING);
        members.put("LEFT_THUMB", LEFT_THUMB);
        members.put("RIGHT_INDEX", RIGHT_INDEX);
        members.put("RIGHT_LITTLE", RIGHT_LITTLE);
        members.put("RIGHT_MIDDLE", RIGHT_MIDDLE);
        members.put("RIGHT_RING", RIGHT_RING);
        members.put("RIGHT_THUMB", RIGHT_THUMB);
        members.put("BOTH_THUMBS", BOTH_THUMBS);
        members.put("LEFT_SLAP", LEFT_SLAP);
        members.put("RIGHT_SLAP", RIGHT_SLAP);
        members.put("FACE", FACE);
        members.put("UNKNOWN", UNKNOWN);
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
     * Returns the String representation of this BiometricPosition
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
     * Returns a new BiometricPosition based on the given String
     * value.
     * 
     * @param string
     * @return BiometricPosition
     */
    public static auth_2_0.types.BiometricPosition valueOf(String string)
    {
        Object obj = null;
        if (string != null) obj = _memberTable.get(string);
        if (obj == null) {
            String err = "'" + string + "' is not a valid BiometricPosition";
            throw new IllegalArgumentException(err);
        }
        return (BiometricPosition) obj;
    } //-- auth_2_0.types.BiometricPosition valueOf(java.lang.String) 

}
