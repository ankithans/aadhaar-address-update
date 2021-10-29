package in.gov.uidai.otpapiclient.model;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;

@XmlType(name = "type")
@XmlEnum
public enum Type {

	A, M,V;

	public String value() {
		return name();
	}

	public static Type fromValue(String v) {
		return valueOf(v);
	}

}
