package com.example.myfavouriteservice.controller;

import java.util.List;

import com.example.myfavouriteservice.exception.CountryAlreadyExistsException;
import com.example.myfavouriteservice.exception.CountryNotFoundException;
import com.example.myfavouriteservice.model.Covid;
import com.example.myfavouriteservice.model.User;
import com.example.myfavouriteservice.service.FavouriteService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:4200", methods = {RequestMethod.GET, RequestMethod.POST,RequestMethod.DELETE})
@RequestMapping("/api/v2")
public class ServiceController {

    private ResponseEntity responseEntity;

    private FavouriteService favService;

    public ServiceController() {
        super();
    }

    @Autowired
    public ServiceController(FavouriteService favService) {
        super();
        this.favService = favService;
    }


    @PostMapping("/user/{username}/country")
    public ResponseEntity<?> addCountryToFavoriteList(@RequestBody Covid ccovid,
                                                      @PathVariable String username) throws CountryAlreadyExistsException {

        if(username!=null) {
            try {
                User user1 = favService.saveCountryToFavorite(ccovid, username);
                if(user1.getUsername()!=null) {
                    responseEntity = new ResponseEntity<User>(user1, HttpStatus.CREATED);
                }
                else {
                    System.out.println("Useername not found...mayebe its null");
                }

            } catch (CountryAlreadyExistsException e) {
                throw new CountryAlreadyExistsException();
            } catch (Exception e) {
                responseEntity = new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);

            }
            return responseEntity;

        }
        else {
            return null;
        }



    }

    @DeleteMapping("/user/{username}/{country}")
    public ResponseEntity<?> deleteFromList(@PathVariable String country, @PathVariable String username)
            throws CountryNotFoundException {

        try {
            User user1 = favService.deleteCountryFromFavorite(country, username);
            responseEntity = new ResponseEntity<User>(user1, HttpStatus.OK);
        } catch (CountryNotFoundException e) {
            throw new CountryNotFoundException();
        } catch (Exception e) {
            responseEntity = new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);

        }
        return responseEntity;

    }

    @GetMapping("/user/{username}/country")
    public ResponseEntity<?> getCountryList(@PathVariable String username) throws CountryNotFoundException {

        try {
            List<Covid> countryList = favService.getCountryList(username);
            responseEntity = new ResponseEntity(countryList, HttpStatus.OK);
        } catch (Exception e) {
            responseEntity = new ResponseEntity(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);

        }
        return responseEntity;

    }


}





