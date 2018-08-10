package entity;

public class UserTariffEntity {
    private long user_id;
    private int tariff_id;

    public UserTariffEntity(long user_id, int tariff_id) {
        this.user_id = user_id;
        this.tariff_id = tariff_id;
    }

    public long getUser_id() {
        return user_id;
    }

    public int getTariff_id() {
        return tariff_id;
    }

    public void setUser_id(long user_id) {
        this.user_id = user_id;
    }

    public void setTariff_id(int tariff_id) {
        this.tariff_id = tariff_id;
    }
}
