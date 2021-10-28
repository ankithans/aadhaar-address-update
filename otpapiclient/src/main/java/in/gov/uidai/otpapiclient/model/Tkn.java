package in.gov.uidai.otpapiclient.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Tkn")
public class Tkn {

	@XmlAttribute(name = "type")
	protected String type;
	@XmlAttribute(name = "value")
	protected String value;

	public String getType() {
		return type;
	}

	public void setType(String value) {
		this.type = value;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

}
