package com.madhacks.backend.controller;

import com.madhacks.backend.common.ErrorResponse;
import com.madhacks.backend.model.User;
import com.madhacks.backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;


class UserWithoutPassword {
    private String email;
    private int id;
    public UserWithoutPassword(User user){
        this.email = user.getUsername();
        this.id = user.getId();
    }

    public int getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }
}
@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping("")
    public List<User> list(){
        return userService.listAllUsers();
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserWithoutPassword> get(@PathVariable Integer id) {
        try {
            User user = userService.getUser(id);
            return new ResponseEntity<UserWithoutPassword>(new UserWithoutPassword(user), HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<UserWithoutPassword>(HttpStatus.NOT_FOUND);
        }
    }
    @PostMapping("/")
    public void add(@RequestBody User user) {
        userService.saveUser(user);
    }

    @GetMapping("/user/{username}")
    public ResponseEntity getUserByUserName(@PathVariable String username){
        var user = userService.getUserByUserName(username);
        if(user != null){
            return new ResponseEntity<UserWithoutPassword>(new UserWithoutPassword(user), HttpStatus.OK);
        }
        return new ResponseEntity<ErrorResponse>(new ErrorResponse("user not found"), HttpStatus.NOT_FOUND);
    }
}
