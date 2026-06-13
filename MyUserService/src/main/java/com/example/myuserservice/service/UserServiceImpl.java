package com.example.myuserservice.service;

import java.util.Optional;

import com.example.myuserservice.exception.PasswordMisMatchException;
import com.example.myuserservice.exception.SameUsernameExistsException;
import com.example.myuserservice.exception.UserAlreadyExistsException;
import com.example.myuserservice.exception.UserNotFoundException;
import com.example.myuserservice.model.ChangePassword;
//import com.example.myuserservice.model.LogUser;
import com.example.myuserservice.model.User;
import com.example.myuserservice.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

   // private UserUtil userUtil;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        super();
        this.userRepository = userRepository;
    }

    @Override
    public User updateDetails(User user, String username) throws SameUsernameExistsException {
        Optional<User> user1 = userRepository.findByUsername(username);
        Optional<User> user3 = userRepository.findByUsername(user.getUsername());
        if(user3.isEmpty())
        {
            User user2 = user1.get();
            user2.setEmail(String.valueOf(user.getEmail()));
            user2.setUsername(user.getUsername());
            return userRepository.save(user2);
        }
        throw new SameUsernameExistsException();
    }
    @Override
    public User updatePassword(ChangePassword changepassword, String username) throws PasswordMisMatchException {
        Optional<User> user1 = userRepository.findByUsername(username);
        User user2 = user1.get();
        //Optional<User> user3 = userRepository.findByUsername();
        if(user2.getPassword().equals(changepassword.getOldpassword()))
        {
            user2.setPassword(changepassword.getNewpassword());
            // User user2 = user1.get();
            //user2.setEmail(user.getEmail());
            // user2.setUsername(user.getUsername());
            return userRepository.save(user2);
        }
        throw new PasswordMisMatchException();
    }

    @Override
    public User registerUser(User user) throws UserAlreadyExistsException{
        // TODO Auto-generated method stub

        //Optional<User> userexisting = userRepository.findByUsername(user.getUsername());

        if (userRepository.findById(user.getEmail()).isPresent()) {
            throw new UserAlreadyExistsException();
        }

        return userRepository.save(user);
    }

    @Override
    public User findByUsername(String username) throws UserNotFoundException {
        Optional<User> optional = userRepository.findByUsername(username);
        if (!optional.isPresent()) {
            throw new UserNotFoundException();
        }
        User user = optional.get();
        return user;
    }

    @Override
    public List<User> getUser(){
        return userRepository.findAll();
    }


    @Override
    public User validateUser(String userName, String password) throws UserNotFoundException {
        // TODO Auto-generated method stub
        User user = userRepository.findByUsernameAndPassword(userName, password);

        if (user == null) {
            throw new UserNotFoundException();
        }

        return user;
    }








}
