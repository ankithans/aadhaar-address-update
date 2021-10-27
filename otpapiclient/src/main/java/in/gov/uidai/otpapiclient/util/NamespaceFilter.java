/*******************************************************************************
 * DISCLAIMER: The sample code or utility or tool described herein
 *    is provided on an "as is" basis, without warranty of any kind.
 *    UIDAI does not warrant or guarantee the individual success
 *    developers may have in implementing the sample code on their
 *    environment. 
 *    
 *    UIDAI does not warrant, guarantee or make any representations
 *    of any kind with respect to the sample code and does not make
 *    any representations or warranties regarding the use, results
 *    of use, accuracy, timeliness or completeness of any data or
 *    information relating to the sample code. UIDAI disclaims all
 *    warranties, express or implied, and in particular, disclaims
 *    all warranties of merchantability, fitness for a particular
 *    purpose, and warranties related to the code, or any service
 *    or software related thereto. 
 *    
 *    UIDAI is not responsible for and shall not be liable directly
 *    or indirectly for any direct, indirect damages or costs of any
 *    type arising out of use or any action taken by you or others
 *    related to the sample code.
 *    
 *    THIS IS NOT A SUPPORTED SOFTWARE.
 ******************************************************************************/

package in.gov.uidai.otpapiclient.util;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.XMLFilterImpl;

/**
 * Class to add namespace before parsing XML document.
 * 
 * Refer {@link http://stackoverflow.com/questions/277502/jaxb-how-to-ignore-namespace-during-unmarshalling-xml-document} 
 * for more details why this class is needed
 */
public class NamespaceFilter extends XMLFilterImpl {
 
    private String usedNamespaceUri; 
    private boolean addNamespace; 
 
    //State variable 
    private boolean addedNamespace = false; 
 
    public NamespaceFilter(String namespaceUri,
                           boolean addNamespace) {
        super(); 
 
        if (addNamespace) 
            this.usedNamespaceUri = namespaceUri; 
        else  
            this.usedNamespaceUri = ""; 
        this.addNamespace = addNamespace; 
    } 
 
 
 
    @Override 
    public void startDocument() throws SAXException { 
        super.startDocument(); 
        if (addNamespace) { 
            startControlledPrefixMapping(); 
        } 
    } 
 
 
 
    @Override 
    public void startElement(String arg0, String arg1, String arg2, 
            Attributes arg3) throws SAXException { 
 
        super.startElement(this.usedNamespaceUri, arg1, arg2, arg3); 
    } 
 
    @Override 
    public void endElement(String arg0, String arg1, String arg2) 
            throws SAXException { 
 
        super.endElement(this.usedNamespaceUri, arg1, arg2); 
    } 
 
    @Override 
    public void startPrefixMapping(String prefix, String url) 
            throws SAXException { 
 
 
        if (addNamespace) { 
            this.startControlledPrefixMapping(); 
        } else { 
            //Remove the namespace, i.e. don´t call startPrefixMapping for parent! 
        } 
 
    } 
 
    private void startControlledPrefixMapping() throws SAXException { 
 
        if (this.addNamespace && !this.addedNamespace) { 
            //We should add namespace since it is set and has not yet been done. 
            super.startPrefixMapping("", this.usedNamespaceUri); 
 
            //Make sure we dont do it twice 
            this.addedNamespace = true; 
        } 
    } 
 
} 
