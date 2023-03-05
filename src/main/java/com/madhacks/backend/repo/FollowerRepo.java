package com.madhacks.backend.repo;

import com.madhacks.backend.model.Follower;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public interface FollowerRepo extends JpaRepository<Follower, String> {
    @Query(value = "select distinct followed_user from following where follower = ?1", nativeQuery = true)
    List<String>  getFollowersByUserName(String username);
    @Modifying
    @Query(value = "insert into following (follower, followed_user) values (?1, ?2)", nativeQuery = true)
    void follow(String follower, String followedUser);
    @Modifying
    @Query(value = "delete from following where follower = ?1 and followed_user = ?2", nativeQuery = true)
    void unfollow(String follower, String followedUser);
}
