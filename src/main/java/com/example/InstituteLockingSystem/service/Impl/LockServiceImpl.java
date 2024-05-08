package com.example.InstituteLockingSystem.service.Impl;

import aj.org.objectweb.asm.commons.GeneratorAdapter;
import com.example.InstituteLockingSystem.entity.CollegeLockStatus;
import com.example.InstituteLockingSystem.entity.LockConstant;
import com.example.InstituteLockingSystem.entity.StandaloneLockStatus;
import com.example.InstituteLockingSystem.entity.UniversityLockStatus;
import com.example.InstituteLockingSystem.repository.CollegeLockStatusRepository;
import com.example.InstituteLockingSystem.repository.StandaloneLockStatusRepository;
import com.example.InstituteLockingSystem.repository.UniversityLockStatusRepository;
import com.example.InstituteLockingSystem.service.LockService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;
import java.util.Arrays;


@Service
public class LockServiceImpl implements LockService {

    @Autowired
    private CollegeLockStatusRepository collegeRepository;

    @Autowired
    private StandaloneLockStatusRepository standaloneRepository;

    @Autowired
    private UniversityLockStatusRepository universityRepository;



    @Override
    public void lockData(String institutionType, String aisheCode, int surveyYear, boolean status, String constant) {
        // Check if the provided institutionType is valid
        validateInstitutionType(institutionType);

        // Check if the AISHE code is unique
        validateAisheCodeUniqueness(aisheCode);

        // Check if the survey year is 2022
        validateSurveyYear(surveyYear);



        // Proceed with the locking operation based on the institution type
        switch (institutionType) {
            case "College":
                lockCollegeData(aisheCode, surveyYear, status, constant);
                break;
            case "Standalone":
                lockStandaloneData(aisheCode, surveyYear, status, constant);
                break;
            case "University":
                lockUniversityData(aisheCode, surveyYear, status, constant);
                break;
            default:
                throw new IllegalArgumentException("Invalid institution type: " + institutionType);
        }
    }

    private void validateInstitutionType(String institutionType) {
        if (!Arrays.asList("College", "Standalone", "University").contains(institutionType)) {
            throw new IllegalArgumentException("Invalid institution type: " + institutionType);
        }
    }

    private void validateAisheCodeUniqueness(String aisheCode) {
        if (collegeRepository.existsByAisheCode(aisheCode) ||
                standaloneRepository.existsByAisheCode(aisheCode) ||
                universityRepository.existsByAisheCode(aisheCode)) {
            throw new IllegalStateException("AISHE code must be unique for CSU (College, Standalone, University).");
        }
    }

    private void validateSurveyYear(int surveyYear) {
        if (surveyYear != 2022) {
            throw new IllegalArgumentException("Survey year must be 2022.");
        }
    }

    private void lockCollegeData(String aisheCode, int surveyYear, boolean status, String constant) {

        // Determine whether boolean values should be set to true or false based on the constant
        boolean shouldSetValuesToTrue = false;
        try {
            shouldSetValuesToTrue = LockConstant.valueOf(constant).shouldSetBooleanValuesToTrue(constant);
        } catch (IllegalArgumentException e) {
            // Constant not found in enum, set boolean values to false
            shouldSetValuesToTrue = false;
        }
        // Lock data for College
        CollegeLockStatus collegeLockStatus = new CollegeLockStatus();
        collegeLockStatus.setAisheCode(aisheCode);
        collegeLockStatus.setSurveyYear(surveyYear);

        // Set boolean values based on the shouldSetValuesToTrue flag
        Field[] fields = CollegeLockStatus.class.getDeclaredFields();
        for (Field field : fields) {
            if (field.getType() == Boolean.class || field.getType() == boolean.class) {
                try {
                    field.setAccessible(true);

                    field.set(collegeLockStatus, shouldSetValuesToTrue);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
        collegeRepository.save(collegeLockStatus);
    }

    private void lockStandaloneData(String aisheCode, int surveyYear, boolean status, String constant) {

        // Determine whether boolean values should be set to true or false based on the constant
        boolean shouldSetValuesToTrue = false;
        try {
            shouldSetValuesToTrue = LockConstant.valueOf(constant).shouldSetBooleanValuesToTrue(constant);
        } catch (IllegalArgumentException e) {
            // Constant not found in enum, set boolean values to false
            shouldSetValuesToTrue = false;
        }

        // Implement locking logic for standalone data based on the constant parameter
        StandaloneLockStatus standaloneLockStatus = new StandaloneLockStatus();
        standaloneLockStatus.setAisheCode(aisheCode);
        standaloneLockStatus.setSurveyYear(surveyYear);

        // Set boolean values based on the shouldSetValuesToTrue flag
        Field[] fields = StandaloneLockStatus.class.getDeclaredFields();
        for (Field field : fields) {
            if (field.getType() == Boolean.class || field.getType() == boolean.class) {
                try {
                    field.setAccessible(true);
                    field.set(standaloneLockStatus, shouldSetValuesToTrue);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }

        standaloneRepository.save(standaloneLockStatus);
    }

    private void lockUniversityData(String aisheCode, int surveyYear, boolean status, String constant) {

        // Determine whether boolean values should be set to true or false based on the constant
        boolean shouldSetValuesToTrue = false;
        try {
            shouldSetValuesToTrue = LockConstant.valueOf(constant).shouldSetBooleanValuesToTrue(constant);
        } catch (IllegalArgumentException e) {
            // Constant not found in enum, set boolean values to false
            shouldSetValuesToTrue = false;
        }

        // Implement locking logic for university data based on the constant parameter
        UniversityLockStatus universityLockStatus = new UniversityLockStatus();
        universityLockStatus.setAisheCode(aisheCode);
        universityLockStatus.setSurveyYear(surveyYear);

        Field[] fields = UniversityLockStatus.class.getDeclaredFields();
        for (Field field : fields) {
            if (field.getType() == Boolean.class || field.getType() == boolean.class) {
                try {
                    field.setAccessible(true);
                    field.set(universityLockStatus, shouldSetValuesToTrue);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
        universityRepository.save(universityLockStatus);

    }
}

