package com.bank.person.properties;

import com.bank.commons.ValidateData;

public class Identification {
    private String FIELD_NAME = "identification";
    private String value;

    public Identification(String value) {
        if(ValidateData.string(value, FIELD_NAME)){
            this.value = value;
        }
    }

    public String getValue(){ return value; }
}
