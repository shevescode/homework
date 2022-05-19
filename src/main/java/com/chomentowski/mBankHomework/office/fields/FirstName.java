package com.chomentowski.mBankHomework.office.fields;

public class FirstName {
    private final String value;

    private FirstName(String value) {
        this.value = value;
    }

    public static FirstName of(String firstName) {
        if(firstName == null || firstName.equals("")) {
            throw new IllegalArgumentException("First name cannot be null or empty");
        }
        return new FirstName(firstName);
    }

    public String getValue() {
        return value;
    }
}
