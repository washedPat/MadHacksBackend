package com.madhacks.backend.model;

import jakarta.persistence.*;

@Entity
@Table(name="users")
public class User {
    private int id;
    private String username;
    private String password;

    public User(int id, String username, String password){
        this.id = id;
        this.username = username;
        this.password = password;
    }

    public User(String username, String password){
        this.username = username;
        this.password = password;
    }

    public User(){}
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getId(){
        return id;
    }

    public void setId(int id){
        this.id = id;
    }

    public void setUsername(String username){
        this.username = username;
    }

    public void setPassword(String password){
        this.password = password;
    }

    public String getUsername(){
        return this.username;
    }
    public String getPassword(){
        return this.password;
    }
}
