package com.madhacks.backend.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="condition")
public class Condition {
    @Id
    private String userName;
    private String condition;

    public Condition(String userName, String condition){
        this.userName = userName;
        this.condition = condition;
    }
    public Condition(){}

    public String getCondition() {
        return condition;
    }

    public String getUserName() {
        return userName;
    }
}
