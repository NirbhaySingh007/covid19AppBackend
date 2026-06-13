package com.example.myuserservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code= HttpStatus.CONFLICT , reason="Passord Miss Match")
public class PasswordMisMatchException extends Exception {

}


