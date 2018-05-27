package com.karthik.github.demo.utility;

import com.karthik.github.demo.beans.UserResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice("com.karthik.github.demo")
public class UserExceptionHandler {

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public ResponseEntity<UserResponse> handleException(Exception exception){
        UserResponse userResponse = new UserResponse();
        userResponse.setStatus(-1);
        userResponse.setMessage(exception.getMessage());
        ResponseEntity<UserResponse> responseEntity= new ResponseEntity<UserResponse>(userResponse, HttpStatus.NOT_FOUND);
        return responseEntity;
    }
}
