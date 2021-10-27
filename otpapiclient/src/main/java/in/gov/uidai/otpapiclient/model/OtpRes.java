package in.gov.uidai.otpapiclient.model;

import javax.xml.bind.annotation.*;
import javax.xml.datatype.XMLGregorianCalendar;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "OtpRes")
@XmlRootElement(namespace = "http://www.uidai.gov.in/authentication/otp/1.0")
public class OtpRes {

    @XmlAttribute(name = "txn")
    protected String txn;
    @XmlAttribute(name = "err")
    protected String err;
    @XmlAttribute(name = "code")
    protected String code;
    @XmlAttribute(name = "ts")
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar ts;
    @XmlAttribute(name = "ret")
    protected OtpResult ret;
    @XmlAttribute(name = "actn")
    protected String actn;

    public String getTxn() {
        return txn;
    }

    public void setTxn(String value) {
        this.txn = value;
    }

    public String getErr() {
        return err;
    }

    public void setErr(String value) {
        this.err = value;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String value) {
        this.code = value;
    }

    public XMLGregorianCalendar getTs() {
        return ts;
    }

    public void setTs(XMLGregorianCalendar value) {
        this.ts = value;
    }

    public OtpResult getRet() {
        return ret;
    }

    public void setRet(OtpResult value) {
        this.ret = value;
    }


	public String getActn() {
		return actn;
	}

	public void setActn(String actn) {
		this.actn = actn;
	}

}
