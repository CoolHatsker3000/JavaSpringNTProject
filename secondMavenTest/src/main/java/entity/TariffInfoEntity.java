package entity;

public class TariffInfoEntity {
    private int tariff_id;
    private int attr_id;
    private String attr_v;

    public TariffInfoEntity(int tariff_id, int attr_id, String attr_v) {
        this.tariff_id = tariff_id;
        this.attr_id = attr_id;
        this.attr_v = attr_v;
    }

    public int getTariff_id() {
        return tariff_id;
    }

    public int getAttr_id() {
        return attr_id;
    }

    public String getAttr_v() {
        return attr_v;
    }

    public void setTariff_id(int tariff_id) {
        this.tariff_id = tariff_id;
    }

    public void setAttr_id(int attr_id) {
        this.attr_id = attr_id;
    }

    public void setAttr_v(String attr_v) {
        this.attr_v = attr_v;
    }
}
