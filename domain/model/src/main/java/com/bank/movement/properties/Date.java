package com.bank.movement.properties;

import com.bank.commons.ValidateData;

public class Date {
    private String FIELD_NAME = "date";
    private String value;

    public Date(String value) {
        if(ValidateData.string(value, FIELD_NAME)){
            this.value = value;
        }
    }

    public String getValue(){ return value; }
}
