package com.stone.may;

import java.io.Serializable;

public class Person implements Serializable {

    private String username;

    private String nick;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public Person(String username, String nick) {
        this.username = username;
        this.nick = nick;
    }

    @Override
    public String toString() {
        return "Person{" +
                "username='" + username + '\'' +
                ", nick='" + nick + '\'' +
                '}';
    }
}
