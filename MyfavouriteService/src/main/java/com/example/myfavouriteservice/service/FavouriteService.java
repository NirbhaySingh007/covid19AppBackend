package com.example.myfavouriteservice.service;

import java.util.List;

import com.example.myfavouriteservice.exception.CountryAlreadyExistsException;
import com.example.myfavouriteservice.exception.CountryNotFoundException;
import com.example.myfavouriteservice.model.Covid;
import com.example.myfavouriteservice.model.User;

import org.springframework.stereotype.Service;


public interface FavouriteService {

    public User saveCountryToFavorite(Covid Covid, String username) throws CountryAlreadyExistsException;
    public User deleteCountryFromFavorite(String trackId , String username ) throws CountryNotFoundException;
    public List<Covid> getCountryList(String username ) throws Exception;

}

