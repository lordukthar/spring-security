package com.example.demo;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

import org.springframework.validation.annotation.Validated;

@RestController
@Validated
public class UserController {


    @GetMapping("/users")
    List<User> findAll() {
        return Arrays.asList(new User("Jonas"));
    }


}
