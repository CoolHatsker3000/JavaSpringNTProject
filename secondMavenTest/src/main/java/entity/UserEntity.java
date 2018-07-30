package entity;

public class UserEntity {
    private long user_id;
    private float user_balance;

    public UserEntity(long user_id, float user_balance) {
        this.user_id = user_id;
        this.user_balance = user_balance;
    }

    public long getUser_id() {
        return user_id;
    }

    public float getUser_balance() {
        return user_balance;
    }

    public void setUser_id(long user_id) {
        this.user_id = user_id;
    }

    public void setUser_balance(float user_balance) {
        this.user_balance = user_balance;
    }

}
