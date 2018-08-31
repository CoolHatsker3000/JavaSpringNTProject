package entity;

import models.User;

public class UserEntity {

    private long userId;
    private String userPassword;
    private double userBalance;

    public UserEntity(long userId,String password, double userBalance) {
        this.userId = userId;
        this.userPassword=password;
        this.userBalance = userBalance;
    }
    public UserEntity(User user){
        this.userId=Long.parseLong(user.getUserId());
        this.userPassword=user.getUserPassword();
        this.userBalance=Double.parseDouble(user.getUserBalance());
    }

    public long getUserId() {
        return userId;
    }

    public double getUserBalance() {
        return userBalance;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public void setUserBalance(double userBalance) {
        this.userBalance = userBalance;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }
}
