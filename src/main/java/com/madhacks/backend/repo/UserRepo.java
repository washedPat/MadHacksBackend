package com.madhacks.backend.repo;

import com.madhacks.backend.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRepo extends JpaRepository<User, Integer> {
    @Query(value = "select * from users where username = ?1", nativeQuery = true)
    List<User> findByUsername(String userName);
    @Query(value = "select * from users where username = ?1 and password = ?2", nativeQuery = true)
    List<User> findByUsernameAndPassword(String userName, String password);
}
