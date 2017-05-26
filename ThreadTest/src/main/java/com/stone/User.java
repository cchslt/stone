package com.stone;

/**
 * Created by chenchen on 2017/5/27.
 */
public class User {
    private String userName;
    private int old;


    public User(String userName, int old) {
        this.userName = userName;
        this.old = old;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getOld() {
        return old;
    }

    public void setOld(int old) {
        this.old = old;
    }
}
