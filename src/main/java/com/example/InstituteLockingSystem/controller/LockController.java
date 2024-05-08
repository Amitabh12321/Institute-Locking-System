package com.example.InstituteLockingSystem.controller;

import com.example.InstituteLockingSystem.entity.LockParameter;
import com.example.InstituteLockingSystem.service.LockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/lock")
public class LockController {

    private final LockService lockService;

    @Autowired
    public LockController(LockService lockService) {
        this.lockService = lockService;
    }

    // http://localhost:8080/lock/institution
    @PostMapping("/institution")
    public ResponseEntity<String> lockInstitutionData(@RequestBody LockParameter request) {
        try {
            lockService.lockData(request.getInstitutionType(), request.getAisheCode(), request.getSurveyYear(),
                    request.getStatus(), request.getConstant().name());
            return ResponseEntity.ok("Data locked successfully.");
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

}

