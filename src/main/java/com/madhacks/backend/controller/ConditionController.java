package com.madhacks.backend.controller;

import com.madhacks.backend.model.Condition;
import com.madhacks.backend.service.ConditionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

class ConditionForm {
    private String condition;

    public String getCondition() {
        return condition;
    }
}
@RestController
public class ConditionController {
    @Autowired
    ConditionService conditionService;
    @GetMapping("/getCondition/{userName}")
    public ResponseEntity<String> getInterest(@PathVariable String userName){
        return new ResponseEntity<>(conditionService.getConditionByUserName(userName), HttpStatus.OK);
    }

    @PostMapping("/setCondition/{userName}")
    public ResponseEntity setInterest(@PathVariable String userName, @RequestBody ConditionForm form){
        conditionService.addCondition(userName, form.getCondition());
        return new ResponseEntity(HttpStatus.OK);
    }
}
