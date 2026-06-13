package com.example.myfavouriteservice.model;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class User {

    @Id
    private String username;


    private List<Covid> CountryList;


    public String getUsername() {
        return username;
    }


    public void setUsername(String username) {
        this.username = username;
    }





    public List<Covid> getCountryList() {
        return CountryList;
    }


    public void setCountryList(List<Covid> countryList) {
        CountryList = countryList;
    }


    @Override
    public String toString() {
        return "User [username=" + username + ", covidList=" + CountryList + "]";
    }


    public User(String username, List<Covid> CountryList) {
        super();
        this.username = username;
        this.CountryList = CountryList;
    }


    public User() {
        super();
        //TODO Auto-generated constructor stub
    }


}

