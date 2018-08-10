package entity;

public class TariffAttrEntity {
    private int attrId;
    private String attrName;

    public TariffAttrEntity(int attrId, String attrName) {
        this.attrId = attrId;
        this.attrName = attrName;
    }

    public int getAttrId() {
        return attrId;
    }

    public String getAttrName() {
        return attrName;
    }

    public void setAttrId(int attrId) {
        this.attrId = attrId;
    }

    public void setAttrName(String attrName) {
        this.attrName = attrName;
    }
}
