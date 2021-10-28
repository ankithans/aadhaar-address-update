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
package auth_2_0;

import auth_2_0.AuthRes;

/**
 * This class represents Auth Response.  It encapsulates the XML and its
 * Java representation obtained after XML parsing.
 * 
 * @author UIDAI
 *
 */
public class AuthResponseDetailsV2 {

	private AuthRes authRes;
	private String xml;
	
	public AuthResponseDetailsV2(String xml, AuthRes res) {
		this.authRes = res;
		this.xml = xml;
	}

	public AuthRes getAuthRes() {
		return authRes;
	}
	
	public String getXml() {
		return xml;
	}
}
