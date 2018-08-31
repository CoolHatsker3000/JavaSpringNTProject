package entity;

import models.TariffInfo;

public class TariffInfoEntity {
    private int tariffId;
    private int attrId;
    private String attrV;

    public TariffInfoEntity(int tariffId, int attrId, String attrV) {
        this.tariffId = tariffId;
        this.attrId = attrId;
        this.attrV = attrV;
    }
    public TariffInfoEntity(TariffInfo tariffInfo){
        this.tariffId=Integer.parseInt(tariffInfo.getTariffId());
        this.attrId=Integer.parseInt(tariffInfo.getAttrId());
        this.attrV=tariffInfo.getAttrV();
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
