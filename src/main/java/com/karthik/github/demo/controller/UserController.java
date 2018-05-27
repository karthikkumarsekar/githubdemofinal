package com.karthik.github.demo.controller;

import com.karthik.github.demo.beans.UserResponse;
import com.karthik.github.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping(value="/insert/{userName}",  method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    Object insertUserDetails(@PathVariable("userName") String userName) {
        UserResponse userResponse = new UserResponse();
        Object object = userService.getUserDetails(userName.trim());
        return object;
    }
}
