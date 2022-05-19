package com.chomentowski.mBankHomework.office;

public class Employee extends PersonBase implements PersonInterface {

    public Employee(String firstName, String surName) {
        super(firstName, surName);
    }

    @Override
    public Position getPosition() {
        return Position.EMPLOYEE;
    }
}
