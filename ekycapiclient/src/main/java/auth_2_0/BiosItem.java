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

import java.io.Serializable;
import org.exolab.castor.xml.Marshaller;
import org.exolab.castor.xml.Unmarshaller;

/**
 * Class BiosItem.
 * 
 * @version $Revision$ $Date$
 */
public class BiosItem implements Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _bio
     */
    private auth_2_0.Bio _bio;


      //----------------/
     //- Constructors -/
    //----------------/

    public BiosItem() 
     {
        super();
    } //-- auth_2_0.BiosItem()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Returns the value of field 'bio'.
     * 
     * @return Bio
     * @return the value of field 'bio'.
     */
    public auth_2_0.Bio getBio()
    {
        return this._bio;
    } //-- auth_2_0.Bio getBio() 

    /**
     * Sets the value of field 'bio'.
     * 
     * @param bio the value of field 'bio'.
     */
    public void setBio(auth_2_0.Bio bio)
    {
        this._bio = bio;
    } //-- void setBio(auth_2_0.Bio) 

}
