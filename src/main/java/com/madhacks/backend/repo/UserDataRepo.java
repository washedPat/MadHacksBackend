package com.madhacks.backend.repo;

import com.madhacks.backend.model.UserData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface UserDataRepo extends JpaRepository<UserData, String> {
    @Modifying
    @Query(value = "update user_data set progress = ?2 where user_name = ?1", nativeQuery = true)
    void updateProgressByUserName(String username, double progress);
}
