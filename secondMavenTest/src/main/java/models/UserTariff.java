package models;

public class UserTariff {
    private String userID;
    private String tariffID;

    public String getUserID() {
        return userID;
    }

    public String getTariffID() {
        return tariffID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public void setTariffID(String tariffID) {
        this.tariffID = tariffID;
    }
}
