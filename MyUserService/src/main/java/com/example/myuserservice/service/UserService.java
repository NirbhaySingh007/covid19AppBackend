package com.example.myuserservice.service;

import com.example.myuserservice.exception.PasswordMisMatchException;
import com.example.myuserservice.exception.SameUsernameExistsException;
import com.example.myuserservice.exception.UserAlreadyExistsException;
import com.example.myuserservice.exception.UserNotFoundException;
import com.example.myuserservice.model.ChangePassword;
//import com.example.myuserservice.model.LogUser;
import com.example.myuserservice.model.User;
//import com.example.myuserservice.repository.UserRepository;
import com.example.myuserservice.service.UserServiceImpl.*;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import java.util.List;

public interface UserService {


    public User registerUser(User user) throws UserAlreadyExistsException;
    public User validateUser(String userName, String password) throws UserNotFoundException;
    public User updateDetails(User user, String username) throws SameUsernameExistsException;
    //User findUserDetailsByUsername(@NotBlank @Length(min = 2, max = 15) String username) throws UserNotFoundException;
    User findByUsername(@NotBlank @Length(min = 2, max = 15) String username) throws UserNotFoundException;

    List<User> getUser();
    public User updatePassword(ChangePassword changepassword,String username) throws PasswordMisMatchException;
}

