package entity;

public class TariffAttrEntity {
    private int attr_id;
    private String attr_name;

    public TariffAttrEntity(int attr_id, String attr_name) {
        this.attr_id = attr_id;
        this.attr_name = attr_name;
    }

    public int getAttr_id() {
        return attr_id;
    }

    public String getAttr_name() {
        return attr_name;
    }

    public void setAttr_id(int attr_id) {
        this.attr_id = attr_id;
    }

    public void setAttr_name(String attr_name) {
        this.attr_name = attr_name;
    }
}
