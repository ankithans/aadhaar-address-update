package ekyc.response;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Resp")
public class Resp {

    private String status;
    private String ko;
    private String ret;
    private String code;
    private String txn;
    private String ts;
    private String err;

    private String kycRes;

    @XmlAttribute
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @XmlAttribute
    public String getKo() {
        return ko;
    }

    public void setKo(String ko) {
        this.ko = ko;
    }

    @XmlAttribute
    public String getRet() {
        return ret;
    }

    public void setRet(String ret) {
        this.ret = ret;
    }

    @XmlAttribute
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @XmlAttribute
    public String getTxn() {
        return txn;
    }

    public void setTxn(String txn) {
        this.txn = txn;
    }

    @XmlAttribute
    public String getTs() {
        return ts;
    }

    public void setTs(String ts) {
        this.ts = ts;
    }

    @XmlAttribute
    public String getErr() {
        return err;
    }

    public void setErr(String err) {
        this.err = err;
    }

    @XmlElement
    public String getKycRes() {
        return kycRes;
    }

    public void setKycRes(String kycRes) {
        this.kycRes = kycRes;
    }
}
