package com.madhacks.backend.service;

import com.madhacks.backend.model.Condition;
import com.madhacks.backend.repo.ConditionRepo;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class ConditionService {
    @Autowired
    ConditionRepo conditionRepo;
    public String getConditionByUserName(String userName){
        var condition = conditionRepo.findById(userName);
        return condition.map(Condition::getCondition).orElse(null);
    }

    public void addCondition(String username, String condition){
        conditionRepo.save(new Condition(username, condition));
    }
}
