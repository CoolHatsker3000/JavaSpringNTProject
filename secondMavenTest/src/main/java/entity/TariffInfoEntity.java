package entity;

public class TariffInfoEntity {
    private int tariffId;
    private int attrId;
    private String attrV;

    public TariffInfoEntity(int tariffId, int attrId, String attrV) {
        this.tariffId = tariffId;
        this.attrId = attrId;
        this.attrV = attrV;
    }

    public int getTariffId() {
        return tariffId;
    }

    public int getAttrId() {
        return attrId;
    }

    public String getAttrV() {
        return attrV;
    }

    public void setTariffId(int tariffId) {
        this.tariffId = tariffId;
    }

    public void setAttrId(int attrId) {
        this.attrId = attrId;
    }

    public void setAttrV(String attrV) {
        this.attrV = attrV;
    }
}
