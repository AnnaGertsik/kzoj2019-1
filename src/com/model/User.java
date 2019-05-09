package com.model;

public class User {
    private String login;
    private String password;
    private String username;
    private int accessLevel;

    public User(){}

    public void setLogin(String login) {
        this.login = login;
    }

    public void setAccessLevel(int accessLevel) {
        this.accessLevel = accessLevel;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getAccessLevel() {
        return accessLevel;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public String getUsername() {
        return username;
    }
}

