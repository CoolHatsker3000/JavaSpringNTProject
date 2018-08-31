package models;

import org.springframework.stereotype.Component;

import javax.validation.constraints.*;


public class User {
    @NotNull(message = "enter your phonenumber")
    @Pattern(regexp = "[0-9]+",message = "Yor phone number must consist from numbers only")
    @Size(min=9,max = 10,message = "phonenumber should be 10 numbers long")
    private String userId;
    @NotNull(message = "enter your password")
    @Size(min=3,max=20,message = "Your password length must be between 3 and 20")
    private String userPassword;
    private String userBalance;

    public String getUserId() {
        return userId;
    }

    public String getUserBalance() {
        return userBalance;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public void setUserBalance(String userBalance) {
        this.userBalance = userBalance;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }
}
