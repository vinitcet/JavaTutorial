package com.vinit.example.controller;

import com.vinit.example.model.Users;
import com.vinit.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/")
    public String index() {
        return "homePage";
    }

    @RequestMapping(value = "/allUsers", produces = "application/json")
    @ResponseBody
    public ResponseEntity getAllUsers() {
        List<Users> allusers = userService.getAllUsers();
        return new ResponseEntity(allusers, HttpStatus.OK);
    }

    @GetMapping(value = "/allUsersXML", produces = "application/xml")
    public List<Users> getAllXmlUsers() {
        List<Users> allusers = userService.getAllUsers();
        return allusers;
    }

    @PostMapping(value = "/addUser",produces = "application/json")
    public ResponseEntity addUser(@RequestBody Users u) {
        userService.addUser(u);
        return new ResponseEntity("Done", HttpStatus.OK);
    }
}
