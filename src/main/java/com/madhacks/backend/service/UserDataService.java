package com.madhacks.backend.service;

import com.madhacks.backend.model.UserData;
import com.madhacks.backend.repo.UserDataRepo;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class UserDataService {
    @Autowired
    UserDataRepo userDataRepo;

    public UserData getUserDataByUserName(String userName){
        return userDataRepo.findById(userName).get();
    }


    public void addUserData(String name, String username, int age, int weight){
        var userData = new UserData(username, name, age, weight);
        userDataRepo.save(userData);
    }

    public void updateProgress(String userName, double progress){
        userDataRepo.updateProgressByUserName(userName, progress);
    }
}
