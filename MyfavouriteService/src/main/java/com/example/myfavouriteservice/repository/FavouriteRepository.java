package com.example.myfavouriteservice.repository;

import com.example.myfavouriteservice.model.User;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface FavouriteRepository extends MongoRepository<User, String> {

    public User findByUsername(String username);

}
