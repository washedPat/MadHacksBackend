package com.madhacks.backend.controller;

import com.madhacks.backend.common.ErrorResponse;
import com.madhacks.backend.model.User;
import com.madhacks.backend.repo.UserRepo;
import com.madhacks.backend.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


class RegistrationForm {
    private String email;
    private String password;

    public String getEmail(){
        return email;
    }

    public String getPassword(){
        return password;
    }
}

class RegistrationResponse {

    private String email;
    private int id;
    public RegistrationResponse(String email, int id){
        this.email = email;
        this.id = id;
    }
    public String getEmail(){return email;}
    public int getId() {return id;}
}

@RestController
public class AuthController {
    @Autowired
    AuthService authService;

    @Autowired
    UserRepo userRepo;

    @PostMapping("/register")
    public ResponseEntity register(@RequestBody RegistrationForm form) {
        boolean found = authService.validateUser(form.getEmail(), form.getPassword());
        if (!found) {
            userRepo.save(new User(form.getEmail(), form.getPassword()));
            var user = userRepo.findByUsername(form.getEmail());
            ResponseEntity<RegistrationResponse> resp = new ResponseEntity<>(
                    new RegistrationResponse(user.getUsername(), user.getId()), HttpStatus.OK);
            return resp;
        }

        return new ResponseEntity<ErrorResponse>(new ErrorResponse("user already exists"), HttpStatus.BAD_REQUEST);
    }

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody RegistrationForm form) {
        boolean found = authService.validateUser(form.getEmail(), form.getPassword());
        if (found) {
            var user = userRepo.findByUsername(form.getEmail());
            ResponseEntity<RegistrationResponse> resp = new ResponseEntity<>(
                    new RegistrationResponse(user.getUsername(), user.getId()), HttpStatus.OK);
            return resp;
        }
        return new ResponseEntity<ErrorResponse>(
                new ErrorResponse("username or passsword is incorrect"), HttpStatus.BAD_REQUEST);
    }
}
