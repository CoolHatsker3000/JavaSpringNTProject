package entity;

import models.TariffAttr;

public class TariffAttrEntity {
    private int attrId;
    private String attrName;

    public TariffAttrEntity(int attrId, String attrName) {
        this.attrId = attrId;
        this.attrName = attrName;
    }

    public TariffAttrEntity(TariffAttr tariffAttr){
        this.attrId=Integer.parseInt(tariffAttr.getAttrId());
        this.attrName=tariffAttr.getAttrName();
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
