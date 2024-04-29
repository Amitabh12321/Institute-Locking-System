package com.example.InstituteLockingSystem.service;

public interface LockService {

    void lockData(String institutionType, String aisheCode, int surveyYear, boolean status, String constant);

}
