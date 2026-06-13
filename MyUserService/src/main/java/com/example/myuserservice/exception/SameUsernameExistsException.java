package com.example.myuserservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code= HttpStatus.CONFLICT , reason="Same Username already exists.")
public class SameUsernameExistsException extends Exception{

}
