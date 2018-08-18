package entity;

import models.User;

public class UserEntity {

    private long userId;
    private double userBalance;

    public UserEntity(long userId, double userBalance) {
        this.userId = userId;
        this.userBalance = userBalance;
    }
    public UserEntity(User user){
        this.userId=Long.parseLong(user.getUserId());
        this.userBalance=Double.parseDouble(user.getUserBalance());
    }

    public long getUserId() {
        return userId;
    }

    public double getUserBalance() {
        return userBalance;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public void setUserBalance(double userBalance) {
        this.userBalance = userBalance;
    }
}
