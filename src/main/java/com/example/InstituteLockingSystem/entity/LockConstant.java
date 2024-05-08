package com.example.InstituteLockingSystem.entity;

public enum LockConstant {

    CONSTANT_ONE,
    CONSTANT_TWO,
    CONSTANT_THREE;
    // Add more constants as needed

    public boolean shouldSetBooleanValuesToTrue(String constant) {
        for (LockConstant lockConstant : LockConstant.values()) {
            if (lockConstant.name().equals(constant)) {
                return true;
            }
        }
        return false;
    }
}
