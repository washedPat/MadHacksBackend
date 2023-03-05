package com.madhacks.backend.service;

import com.madhacks.backend.repo.FollowerRepo;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class FollowService {
    @Autowired
    private FollowerRepo followerRepo;

    public void followUserByUserName(String followerUserName, String followedUserName){
        followerRepo.follow(followerUserName, followedUserName);
    }

    public void unfollowUserByUserName(String followerUserName, String followedUserName){
        followerRepo.unfollow(followerUserName, followedUserName);
    }

    public List<String> getFollowersByUserName(String follower){
        return followerRepo.getFollowersByUserName(follower);
    }

}
