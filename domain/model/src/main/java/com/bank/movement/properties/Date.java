package com.bank.movement.properties;

import com.bank.commons.ValidateData;

import java.time.LocalDate;

public class Date {
    private String FIELD_NAME = "date";
    private LocalDate value;

    public Date(LocalDate value) {
        if(ValidateData.date(value, FIELD_NAME)){
            this.value = value;
        }
    }

    public LocalDate getValue(){ return value; }
}
