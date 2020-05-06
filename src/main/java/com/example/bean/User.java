package com.example.bean;


import java.io.Serializable;

public class User implements Serializable {
    private static final long serialVersionUID = 1L;
    private long userId;
    private String userAccount;
    private String password;
    public long getUserId() {
        return userId;
    }
    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getUserAccount() {
        return userAccount;
    }

    public void setUserAccount(String userAccount) {
        this.userAccount = userAccount;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
