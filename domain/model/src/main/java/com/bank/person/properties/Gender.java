package com.bank.person.properties;

import com.bank.commons.ValidateData;

public class Gender {
    private String FIELD_NAME = "gender";
    private String value;

    public Gender(String value) {
        if(ValidateData.string(value, FIELD_NAME)){
            this.value = value;
        }
    }

    public String getValue(){ return value; }
}
