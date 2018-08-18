package models;

import org.springframework.stereotype.Component;

import javax.validation.constraints.*;


public class User {
    @NotNull(message = "enter your phonenumber")
    @Size(min=9,max = 10,message = "phonenumber should be 10 numbers long")
    private String userId;
    @NotNull(message = "enter your balance")
    @Pattern(regexp = "^\\d+\\.?\\d*")
    private String userBalance;

    public String getUserId() {
        return userId;
    }

    public String getUserBalance() {
        return userBalance;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public void setUserBalance(String userBalance) {
        this.userBalance = userBalance;
    }
}
