package com.madhacks.backend.service;

import com.madhacks.backend.model.User;
import com.madhacks.backend.repo.UserRepo;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class AuthService {
    @Autowired
    private UserRepo userRepo;
    public boolean validateUser(String email, String password){
        var user = userRepo.findByUsernameAndPassword(email, password);
        return user != null;
    }
}
