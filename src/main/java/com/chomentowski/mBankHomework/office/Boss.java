package com.chomentowski.mBankHomework.office;

public class Boss extends PersonBase implements PersonInterface{

    Boss(String firstName, String surName) {
        super(firstName, surName);
    }

    @Override
    public Position getPosition() {
        return Position.BOSS;
    }
}
