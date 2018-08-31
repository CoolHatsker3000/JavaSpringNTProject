package entity;

import models.Tariff;

public class TariffEntity {
    private int tariffId;
    private String tariffName;

    public TariffEntity(int tariffId, String tariffName) {
        this.tariffId = tariffId;
        this.tariffName = tariffName;
    }
    public TariffEntity(Tariff tariff){
        this.tariffId=Integer.parseInt(tariff.getTariffId());
        this.tariffName=tariff.getTariffName();
    }

    public int getTariffId() {
        return tariffId;
    }

    public String getTariffName() {
        return tariffName;
    }

    public void setTariffId(int tariffId) {
        this.tariffId = tariffId;
    }

    public void setTariffName(String tariffName) {
        this.tariffName = tariffName;
    }
}
