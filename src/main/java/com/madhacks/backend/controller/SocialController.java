package com.madhacks.backend.controller;

import com.madhacks.backend.model.UserData;
import com.madhacks.backend.service.UserDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

class SocialData {
    private String name;
    private String imageurl;
    private double progress;

    public SocialData(String name, String imageurl, double progress){
        this.name = name;
        this.imageurl = imageurl;
        this.progress = progress;
    }

    public String getName() {
        return name;
    }

    public double getProgress() {
        return progress;
    }

    public String getImageurl() {
        return imageurl;
    }
}
@RestController
public class SocialController {
    @Autowired
    UserDataService userDataService;
    /*
    image_url,
    name,
    progress,
     */
    @GetMapping("/getFeed")
    public List<SocialData> getFeed(){
        var userData = userDataService.getAllUserData();
        var socialData = new ArrayList<SocialData>();
        for(var data : userData){
            socialData.add(new SocialData(data.getName(), data.getImageurl(), data.getProgress()));
        }
        return socialData;
    }
}
