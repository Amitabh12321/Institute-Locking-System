package com.example.InstituteLockingSystem.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class LockParameter {
    private String institutionType;
    private String aisheCode;
    private Integer surveyYear;
    private Boolean status;
    private LockConstant constant;
}
