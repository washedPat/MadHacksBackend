package com.madhacks.backend.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="user_data")
public class UserData {
    @Id
    private String userName;
    private String name;

    private int age;
    private int weight;

    private double progress;

    public UserData(String userName, String name, int age, int weight){
        this.userName = userName;
        this.name = name;
        this.age = age;
        this.weight = weight;
        this.progress = 0.0;
    }
    public UserData(){}

    public int getAge() {
        return age;
    }
    public int getWeight() {
        return weight;
    }
    public String getName(){
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getUserName(){
        return userName;
    }

    public double getProgress(){
        return progress;
    }
    public void setUserName(String userName){
        this.userName = userName;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public void setWeight(int weight) {
        this.weight = weight;
    }


}
