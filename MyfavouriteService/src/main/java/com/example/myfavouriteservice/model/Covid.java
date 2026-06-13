package com.example.myfavouriteservice.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import org.springframework.data.annotation.Id;

public class Covid {

//	  pid: string;
//	  fullName: String;
//	  name: String;
//	  country:String;

    @Id
    private String country;



    @JsonProperty("infected")
    private String infected;

    @JsonProperty("recovered")
    private String recovered;

    @JsonProperty("deceased")
    private String deceased;

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getInfected() {
        return infected;
    }

    public void setInfected(String infected) {
        this.infected = infected;
    }

    public String getRecovered() {
        return recovered;
    }

    public void setRecovered(String recovered) {
        this.recovered = recovered;
    }

    public String getDeceased() {
        return deceased;
    }

    public void setDeceased(String deceased) {
        this.deceased = deceased;
    }

    public Covid(String country, String infected, String recovered, String deceased) {
        super();
        this.country = country;
        this.infected = infected;
        this.recovered = recovered;
        this.deceased = deceased;
    }

    public Covid() {
        super();
        //TODO Auto-generated constructor stub
    }

    @Override
    public String toString() {
        return "Player [country=" + country + ", infected=" + infected + ", recovered=" + recovered + ", deceased="
                + deceased + "]";
    }



}