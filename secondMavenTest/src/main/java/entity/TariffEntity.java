package entity;

public class TariffEntity {
    private int tariff_id;
    private String tariff_name;

    public TariffEntity(int tariff_id, String tariff_name) {
        this.tariff_id = tariff_id;
        this.tariff_name = tariff_name;
    }

    public void setTariff_id(int tariff_id) {
        this.tariff_id = tariff_id;
    }

    public void setTariff_name(String tariff_name) {
        this.tariff_name = tariff_name;
    }

    public int getTariff_id() {
        return tariff_id;
    }

    public String getTariff_name() {
        return tariff_name;
    }
}
