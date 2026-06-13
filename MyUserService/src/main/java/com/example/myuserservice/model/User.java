package com.example.myuserservice.model;

import javax.persistence.Entity;
import javax.persistence.Id;
//import javax.persistence.Table;

@Entity
public class User {

    @Id
    private int Id;

    private String username;
    private String email;
    private String password;

    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public Integer getEmail() {
        return Integer.valueOf(email);
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public User(String username, String email, String password) {
        super();
        this.username = username;
        this.email = email;
        this.password = password;
    }
    public User() {
        super();
        //TODO Auto-generated constructor stub
    }
    @Override
    public String toString() {
        return "User [username=" + username + ", email=" + email + ", password=" + password + "]";
    }




}


