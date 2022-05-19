package com.chomentowski.mBankHomework.office.fields;

public class SurName {
    private final String value;

    private SurName(String value) {
        this.value = value;
    }

    public static SurName of(String surName) {
        if(surName == null || surName.equals("")) {
            throw new IllegalArgumentException("First name cannot be null or empty");
        }
        return new SurName(surName);
    }

    public String getValue() {
        return value;
    }
}
