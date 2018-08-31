package entity;

import models.UserTariff;

public class UserTariffEntity {
    private long userId;
    private int tariffId;

    public UserTariffEntity(long userId, int tariffId) {
        this.userId = userId;
        this.tariffId = tariffId;
    }

    public UserTariffEntity(UserTariff userTariff){
        this.userId=Long.parseLong(userTariff.getUserID());
        this.tariffId=Integer.parseInt(userTariff.getTariffID());
    }

    public long getUserId() {
        return userId;
    }

    public int getTariffId() {
        return tariffId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public void setTariffId(int tariffId) {
        this.tariffId = tariffId;
    }
}
