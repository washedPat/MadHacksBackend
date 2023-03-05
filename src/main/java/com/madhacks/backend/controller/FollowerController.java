package com.madhacks.backend.controller;

import com.madhacks.backend.model.Follower;
import com.madhacks.backend.service.FollowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RestController
public class FollowerController {
    @Autowired
    private FollowService followService;

    @PostMapping("/follow/{follower}/{followed}")
    public ResponseEntity followUser(@PathVariable String follower, @PathVariable String followed){
        followService.followUserByUserName(follower, followed);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @PostMapping("/unfollow/{follower}/{followed}")
    public ResponseEntity unfollowUser(@PathVariable String follower, @PathVariable String followed){
        followService.unfollowUserByUserName(follower, followed);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @GetMapping("/{username}/followers")
    public ResponseEntity<List<String>> getFollowers(@PathVariable String username){
        return new ResponseEntity<>(followService.getFollowersByUserName(username), HttpStatus.OK);
    }

}
