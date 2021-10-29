package in.gov.uidai.otpapiclient.model;

import javax.xml.bind.annotation.*;
import javax.xml.datatype.XMLGregorianCalendar;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Otp", propOrder = { "opts", "tkn" })
public class Otp {

	@XmlElement(name = "Opts")
	protected Opts opts;
	@XmlElement(name = "Tkn")
	protected Tkn tkn;
	@XmlAttribute(name = "uid", required = true)
	protected String uid;
	@XmlAttribute(name = "ac", required = true)
	protected String ac;
	@XmlAttribute(name = "sa", required = true)
	protected String sa;
	@XmlAttribute(name = "ver", required = true)
	protected String ver;
	@XmlAttribute(name = "txn", required = true)
	protected String txn;
	@XmlAttribute(name = "lk", required = true)
	protected String lk;
	@XmlAttribute(name = "type")
	protected Type type;
	@XmlAttribute(name = "ts")
	protected XMLGregorianCalendar ts;

	public Opts getOpts() {
		return opts;
	}

	public void setOpts(Opts value) {
		this.opts = value;
	}

	public Tkn getTkn() {
		return tkn;
	}

	public void setTkn(Tkn value) {
		this.tkn = value;
	}

	public String getUid() {
		return uid;
	}

	public void setUid(String value) {
		this.uid = value;
	}

	public String getAc() {
		return ac;
	}

	public void setAc(String value) {
		this.ac = value;
	}

	public String getSa() {
		return sa;
	}

	public void setSa(String value) {
		this.sa = value;
	}

	public String getVer() {
		return ver;
	}

	public void setVer(String value) {
		this.ver = value;
	}

	public String getTxn() {
		return txn;
	}

	public void setTxn(String value) {
		this.txn = value;
	}

	public String getLk() {
		return lk;
	}

	public void setLk(String value) {
		this.lk = value;
	}

	public Type getType() {
		return type;
	}

	public void setType(Type value) {
		this.type = value;
	}

	public XMLGregorianCalendar getTs() {
		return ts;
	}

	public void setTs(XMLGregorianCalendar value) {
		this.ts = value;
	}

}
