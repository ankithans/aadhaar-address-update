package ekyc.response;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Resp")
@XmlAccessorType(XmlAccessType.FIELD)
public class Resp {

    @XmlAttribute
    private String status;
    @XmlAttribute
    private String ko;
    @XmlAttribute
    private String ret;
    @XmlAttribute
    private String code;
    @XmlAttribute
    private String txn;
    @XmlAttribute
    private String ts;

//    @XmlElement
    private String kycRes;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getKo() {
        return ko;
    }

    public void setKo(String ko) {
        this.ko = ko;
    }

    public String getRet() {
        return ret;
    }

    public void setRet(String ret) {
        this.ret = ret;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getTxn() {
        return txn;
    }

    public void setTxn(String txn) {
        this.txn = txn;
    }

    public String getTs() {
        return ts;
    }

    public void setTs(String ts) {
        this.ts = ts;
    }

    public String getKycRes() {
        return kycRes;
    }

    public void setKycRes(String kycRes) {
        this.kycRes = kycRes;
    }
}
