package com.example.myuserservice.model;

public class LogUser {



    private String username;
    private String password;
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public LogUser(String username, String password) {
        super();
        this.username = username;
        this.password = password;
    }
    public LogUser() {
        super();
        //TODO Auto-generated constructor stub
    }
    @Override
    public String toString() {
        return "LogUser [username=" + username + ", password=" + password + "]";
    }




}
