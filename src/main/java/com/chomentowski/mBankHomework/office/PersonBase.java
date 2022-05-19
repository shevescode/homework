package com.chomentowski.mBankHomework.office;

import com.chomentowski.mBankHomework.office.fields.FirstName;
import com.chomentowski.mBankHomework.office.fields.SurName;

public abstract class PersonBase {
    private final FirstName firstName;
    private final SurName surName;

    public PersonBase(String firstName, String surName) {
        this.firstName = FirstName.of(firstName);
        this.surName = SurName.of(surName);
    }

    public String getFirstName() {
        return firstName.getValue();
    }

    public String getSurName() {
        return surName.getValue();
    }
}
