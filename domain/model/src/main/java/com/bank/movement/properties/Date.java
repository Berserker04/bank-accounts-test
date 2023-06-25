package com.bank.movement.properties;

import com.bank.commons.ValidateData;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Date {
    private static String FIELD_NAME = "date";
    private LocalDate value;

    public Date(LocalDate value) {
        if(ValidateData.date(value, FIELD_NAME)){
            this.value = value;
        }
    }

    public Date(String value) {
        if(ValidateData.string(value, FIELD_NAME)){

            String pattern = "yyyy-MM-dd";
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
            LocalDate date = LocalDate.parse(value, formatter);

            if (ValidateData.date(date, FIELD_NAME)) this.value = date;
        }
    }

    public LocalDate getValue(){ return value; }
}
