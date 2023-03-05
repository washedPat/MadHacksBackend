package com.madhacks.backend.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="following")
public class Follower {
    @Id
    private String follower;
    private String followedUser;
    public Follower(String follower, String followedUser){
        this.follower = follower;
        this.followedUser = followedUser;
    }
    public Follower(){}

    public String getFollower() {
        return follower;
    }

    public String getFollowedUser(){
        return followedUser;
    }
}
