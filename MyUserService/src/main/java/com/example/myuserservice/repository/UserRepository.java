package com.example.myuserservice.repository;

import java.util.Optional;

import javax.transaction.Transactional;

//import com.example.myuserservice.model.LogUser;
import com.example.myuserservice.model.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    public User findByUsernameAndPassword(String username, String password);
    public Optional<User> findByUsername(String username);

    @Transactional
    @Modifying
    @Query("delete from User u where u.username = :name ")
    int deletebyname(@Param("name") String name );


}

