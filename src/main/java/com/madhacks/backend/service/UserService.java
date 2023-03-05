package com.madhacks.backend.service;

import com.madhacks.backend.model.User;
import com.madhacks.backend.repo.UserRepo;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class UserService {
    @Autowired
    private UserRepo userRepo;

    public List<User> listAllUsers(){
       return userRepo.findAll();
    }

    public void saveUser(User user){
        userRepo.save(user);
    }

    public User getUser(Integer id){
        return userRepo.findById(id).get();
    }

    public void deleteUser(Integer id){
        userRepo.deleteById(id);
    }

    public User getUserByUserName(String name){
        return userRepo.findByUsername(name);
    }

}
