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

import auth_2_0.Demo;
import org.exolab.castor.mapping.AccessMode;
import org.exolab.castor.xml.TypeValidator;
import org.exolab.castor.xml.XMLFieldDescriptor;
import org.exolab.castor.xml.validators.*;

/**
 * Class DemoDescriptor.
 * 
 * @version $Revision$ $Date$
 */
public class DemoDescriptor extends org.exolab.castor.xml.util.XMLClassDescriptorImpl {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field nsPrefix
     */
    private String nsPrefix;

    /**
     * Field nsURI
     */
    private String nsURI;

    /**
     * Field xmlName
     */
    private String xmlName;

    /**
     * Field identity
     */
    private XMLFieldDescriptor identity;


      //----------------/
     //- Constructors -/
    //----------------/

    public DemoDescriptor() 
     {
        super();
        nsURI = "http://www.uidai.gov.in/authentication/uid-auth-request/2.0";
        xmlName = "Demo";
        
        //-- set grouping compositor
        setCompositorAsSequence();
        org.exolab.castor.xml.util.XMLFieldDescriptorImpl  desc           = null;
        org.exolab.castor.mapping.FieldHandler             handler        = null;
        org.exolab.castor.xml.FieldValidator               fieldValidator = null;
        //-- initialize attribute descriptors
        
        //-- _lang
        desc = new org.exolab.castor.xml.util.XMLFieldDescriptorImpl(String.class, "_lang", "lang", org.exolab.castor.xml.NodeType.Attribute);
        desc.setImmutable(true);
        handler = new org.exolab.castor.xml.XMLFieldHandler() {
            public Object getValue( Object object )
                throws IllegalStateException
            {
                auth_2_0.Demo target = (auth_2_0.Demo) object;
                return target.getLang();
            }
            public void setValue( Object object, Object value)
                throws IllegalStateException, IllegalArgumentException
            {
                try {
                    auth_2_0.Demo target = (auth_2_0.Demo) object;
                    target.setLang( (String) value);
                }
                catch (Exception ex) {
                    throw new IllegalStateException(ex.toString());
                }
            }
            public Object newInstance( Object parent ) {
                return null;
            }
        };
        desc.setHandler(handler);
        desc.setMultivalued(false);
        addFieldDescriptor(desc);
        
        //-- validation code for: _lang
        fieldValidator = new org.exolab.castor.xml.FieldValidator();
        { //-- local scope
            StringValidator typeValidator = new StringValidator();
            typeValidator.setWhiteSpace("preserve");
            fieldValidator.setValidator(typeValidator);
        }
        desc.setValidator(fieldValidator);
        //-- initialize element descriptors
        
        //-- _pi
        desc = new org.exolab.castor.xml.util.XMLFieldDescriptorImpl(auth_2_0.Pi.class, "_pi", "Pi", org.exolab.castor.xml.NodeType.Element);
        handler = new org.exolab.castor.xml.XMLFieldHandler() {
            public Object getValue( Object object )
                throws IllegalStateException
            {
                auth_2_0.Demo target = (auth_2_0.Demo) object;
                return target.getPi();
            }
            public void setValue( Object object, Object value)
                throws IllegalStateException, IllegalArgumentException
            {
                try {
                    auth_2_0.Demo target = (auth_2_0.Demo) object;
                    target.setPi( (auth_2_0.Pi) value);
                }
                catch (Exception ex) {
                    throw new IllegalStateException(ex.toString());
                }
            }
            public Object newInstance( Object parent ) {
                return new auth_2_0.Pi();
            }
        };
        desc.setHandler(handler);
        desc.setNameSpaceURI("http://www.uidai.gov.in/authentication/uid-auth-request/2.0");
        desc.setMultivalued(false);
        addFieldDescriptor(desc);
        
        //-- validation code for: _pi
        fieldValidator = new org.exolab.castor.xml.FieldValidator();
        { //-- local scope
        }
        desc.setValidator(fieldValidator);
        //-- _pa
        desc = new org.exolab.castor.xml.util.XMLFieldDescriptorImpl(auth_2_0.Pa.class, "_pa", "Pa", org.exolab.castor.xml.NodeType.Element);
        handler = new org.exolab.castor.xml.XMLFieldHandler() {
            public Object getValue( Object object )
                throws IllegalStateException
            {
                auth_2_0.Demo target = (auth_2_0.Demo) object;
                return target.getPa();
            }
            public void setValue( Object object, Object value)
                throws IllegalStateException, IllegalArgumentException
            {
                try {
                    auth_2_0.Demo target = (auth_2_0.Demo) object;
                    target.setPa( (auth_2_0.Pa) value);
                }
                catch (Exception ex) {
                    throw new IllegalStateException(ex.toString());
                }
            }
            public Object newInstance( Object parent ) {
                return new auth_2_0.Pa();
            }
        };
        desc.setHandler(handler);
        desc.setNameSpaceURI("http://www.uidai.gov.in/authentication/uid-auth-request/2.0");
        desc.setMultivalued(false);
        addFieldDescriptor(desc);
        
        //-- validation code for: _pa
        fieldValidator = new org.exolab.castor.xml.FieldValidator();
        { //-- local scope
        }
        desc.setValidator(fieldValidator);
        //-- _pfa
        desc = new org.exolab.castor.xml.util.XMLFieldDescriptorImpl(auth_2_0.Pfa.class, "_pfa", "Pfa", org.exolab.castor.xml.NodeType.Element);
        handler = new org.exolab.castor.xml.XMLFieldHandler() {
            public Object getValue( Object object )
                throws IllegalStateException
            {
                auth_2_0.Demo target = (auth_2_0.Demo) object;
                return target.getPfa();
            }
            public void setValue( Object object, Object value)
                throws IllegalStateException, IllegalArgumentException
            {
                try {
                    auth_2_0.Demo target = (Demo) object;
                    target.setPfa( (auth_2_0.Pfa) value);
                }
                catch (Exception ex) {
                    throw new IllegalStateException(ex.toString());
                }
            }
            public Object newInstance( Object parent ) {
                return new auth_2_0.Pfa();
            }
        };
        desc.setHandler(handler);
        desc.setNameSpaceURI("http://www.uidai.gov.in/authentication/uid-auth-request/2.0");
        desc.setMultivalued(false);
        addFieldDescriptor(desc);
        
        //-- validation code for: _pfa
        fieldValidator = new org.exolab.castor.xml.FieldValidator();
        { //-- local scope
        }
        desc.setValidator(fieldValidator);
    } //-- auth_2_0.DemoDescriptor()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Method getAccessMode
     * 
     * 
     * 
     * @return AccessMode
     */
    public AccessMode getAccessMode()
    {
        return null;
    } //-- org.exolab.castor.mapping.AccessMode getAccessMode() 

    /**
     * Method getExtends
     * 
     * 
     * 
     * @return ClassDescriptor
     */
    public org.exolab.castor.mapping.ClassDescriptor getExtends()
    {
        return null;
    } //-- org.exolab.castor.mapping.ClassDescriptor getExtends() 

    /**
     * Method getIdentity
     * 
     * 
     * 
     * @return FieldDescriptor
     */
    public org.exolab.castor.mapping.FieldDescriptor getIdentity()
    {
        return identity;
    } //-- org.exolab.castor.mapping.FieldDescriptor getIdentity() 

    /**
     * Method getJavaClass
     * 
     * 
     * 
     * @return Class
     */
    public Class getJavaClass()
    {
        return Demo.class;
    } //-- java.lang.Class getJavaClass() 

    /**
     * Method getNameSpacePrefix
     * 
     * 
     * 
     * @return String
     */
    public String getNameSpacePrefix()
    {
        return nsPrefix;
    } //-- java.lang.String getNameSpacePrefix() 

    /**
     * Method getNameSpaceURI
     * 
     * 
     * 
     * @return String
     */
    public String getNameSpaceURI()
    {
        return nsURI;
    } //-- java.lang.String getNameSpaceURI() 

    /**
     * Method getValidator
     * 
     * 
     * 
     * @return TypeValidator
     */
    public TypeValidator getValidator()
    {
        return this;
    } //-- org.exolab.castor.xml.TypeValidator getValidator() 

    /**
     * Method getXMLName
     * 
     * 
     * 
     * @return String
     */
    public String getXMLName()
    {
        return xmlName;
    } //-- java.lang.String getXMLName() 

}
