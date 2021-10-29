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
import java.util.ArrayList;
import java.util.Enumeration;
import org.exolab.castor.xml.MarshalException;
import org.exolab.castor.xml.Marshaller;
import org.exolab.castor.xml.Unmarshaller;
import org.exolab.castor.xml.ValidationException;
import org.xml.sax.ContentHandler;

/**
 * One or many biometrics to be
 *  matched.
 *  
 * 
 * @version $Revision$ $Date$
 */
public class Bios implements Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Device Info Hash.
     *  
     */
    private String _dih;

    /**
     * Field _items
     */
    private ArrayList _items;


      //----------------/
     //- Constructors -/
    //----------------/

    public Bios() 
     {
        super();
        _items = new ArrayList();
    } //-- auth_2_0.Bios()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Method addBiosItem
     * 
     * 
     * 
     * @param vBiosItem
     */
    public void addBiosItem(auth_2_0.BiosItem vBiosItem)
        throws IndexOutOfBoundsException
    {
        _items.add(vBiosItem);
    } //-- void addBiosItem(auth_2_0.BiosItem) 

    /**
     * Method addBiosItem
     * 
     * 
     * 
     * @param index
     * @param vBiosItem
     */
    public void addBiosItem(int index, auth_2_0.BiosItem vBiosItem)
        throws IndexOutOfBoundsException
    {
        _items.add(index, vBiosItem);
    } //-- void addBiosItem(int, auth_2_0.BiosItem) 

    /**
     * Method clearBiosItem
     * 
     */
    public void clearBiosItem()
    {
        _items.clear();
    } //-- void clearBiosItem() 

    /**
     * Method enumerateBiosItem
     * 
     * 
     * 
     * @return Enumeration
     */
    public Enumeration enumerateBiosItem()
    {
        return new org.exolab.castor.util.IteratorEnumeration(_items.iterator());
    } //-- java.util.Enumeration enumerateBiosItem() 

    /**
     * Method getBiosItem
     * 
     * 
     * 
     * @param index
     * @return BiosItem
     */
    public auth_2_0.BiosItem getBiosItem(int index)
        throws IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index > _items.size())) {
            throw new IndexOutOfBoundsException();
        }
        
        return (auth_2_0.BiosItem) _items.get(index);
    } //-- auth_2_0.BiosItem getBiosItem(int) 

    /**
     * Method getBiosItem
     * 
     * 
     * 
     * @return BiosItem
     */
    public auth_2_0.BiosItem[] getBiosItem()
    {
        int size = _items.size();
        auth_2_0.BiosItem[] mArray = new auth_2_0.BiosItem[size];
        for (int index = 0; index < size; index++) {
            mArray[index] = (auth_2_0.BiosItem) _items.get(index);
        }
        return mArray;
    } //-- auth_2_0.BiosItem[] getBiosItem() 

    /**
     * Method getBiosItemCount
     * 
     * 
     * 
     * @return int
     */
    public int getBiosItemCount()
    {
        return _items.size();
    } //-- int getBiosItemCount() 

    /**
     * Returns the value of field 'dih'. The field 'dih' has the
     * following description: Device Info Hash.
     *  
     * 
     * @return String
     * @return the value of field 'dih'.
     */
    public String getDih()
    {
        return this._dih;
    } //-- java.lang.String getDih() 

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
     * Method removeBiosItem
     * 
     * 
     * 
     * @param vBiosItem
     * @return boolean
     */
    public boolean removeBiosItem(auth_2_0.BiosItem vBiosItem)
    {
        boolean removed = _items.remove(vBiosItem);
        return removed;
    } //-- boolean removeBiosItem(auth_2_0.BiosItem) 

    /**
     * Method setBiosItem
     * 
     * 
     * 
     * @param index
     * @param vBiosItem
     */
    public void setBiosItem(int index, auth_2_0.BiosItem vBiosItem)
        throws IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index > _items.size())) {
            throw new IndexOutOfBoundsException();
        }
        _items.set(index, vBiosItem);
    } //-- void setBiosItem(int, auth_2_0.BiosItem) 

    /**
     * Method setBiosItem
     * 
     * 
     * 
     * @param biosItemArray
     */
    public void setBiosItem(auth_2_0.BiosItem[] biosItemArray)
    {
        //-- copy array
        _items.clear();
        for (int i = 0; i < biosItemArray.length; i++) {
            _items.add(biosItemArray[i]);
        }
    } //-- void setBiosItem(auth_2_0.BiosItem) 

    /**
     * Sets the value of field 'dih'. The field 'dih' has the
     * following description: Device Info Hash.
     *  
     * 
     * @param dih the value of field 'dih'.
     */
    public void setDih(String dih)
    {
        this._dih = dih;
    } //-- void setDih(java.lang.String) 

    /**
     * Method unmarshalBios
     * 
     * 
     * 
     * @param reader
     * @return Object
     */
    public static Object unmarshalBios(Reader reader)
        throws MarshalException, ValidationException
    {
        return (auth_2_0.Bios) Unmarshaller.unmarshal(auth_2_0.Bios.class, reader);
    } //-- java.lang.Object unmarshalBios(java.io.Reader) 

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
