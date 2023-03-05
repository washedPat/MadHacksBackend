package com.madhacks.backend.controller;

import com.madhacks.backend.model.UserData;
import com.madhacks.backend.service.UserDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/*
userName: "",

 */
class UserDataForm {
    private String userName;
    private String name;
    private int age;
    private int weight;
    private String imageurl;

    public int getAge() {
        return age;
    }

    public int getWeight() {
        return weight;
    }

    public String getName() {
        return name;
    }

    public String getUserName(){
        return userName;
    }

    public String getImageurl() {
        return imageurl;
    }
}
@RestController
public class UserDataController {
    @Autowired
    UserDataService userDataService;

    @PostMapping("/addUserData")
    public ResponseEntity addUserData(@RequestBody UserDataForm userData){
        userDataService.addUserData(
                userData.getName(), userData.getUserName(),
                userData.getAge(), userData.getWeight(), userData.getImageurl());
        return new ResponseEntity(HttpStatus.OK);
    }

    @GetMapping("/getUserData/{username}")
    public ResponseEntity<UserData> addUserData(@PathVariable String username){

        return new ResponseEntity<UserData>(userDataService.getUserDataByUserName(username), HttpStatus.OK);
    }

    @PostMapping("/updateProgress/{username}/{progress}")
    public ResponseEntity updateProgess(@PathVariable String username, @PathVariable double progress){
        userDataService.updateProgress(username, progress);
        return new ResponseEntity(HttpStatus.OK);
    }
}
