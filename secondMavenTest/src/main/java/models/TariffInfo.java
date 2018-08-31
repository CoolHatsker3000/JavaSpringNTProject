package models;

public class TariffInfo {
    private String tariffId;
    private String attrId;
    private String attrV;

    public String getTariffId() {
        return tariffId;
    }

    public String getAttrId() {
        return attrId;
    }

    public String getAttrV() {
        return attrV;
    }

    public void setTariffId(String tariffId) {
        this.tariffId = tariffId;
    }

    public void setAttrId(String attrId) {
        this.attrId = attrId;
    }

    public void setAttrV(String attrV) {
        this.attrV = attrV;
    }
}
