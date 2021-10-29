package in.gov.uidai.otpapiclient.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Opts")
public class Opts {

	@XmlAttribute(name = "ch")
	protected String ch;

	public String getCh() {
		return ch;
	}

	public void setCh(String value) {
		this.ch = value;
	}

}
