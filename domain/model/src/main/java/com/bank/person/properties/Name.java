package com.bank.person.properties;

import com.bank.commons.ValidateData;

public class Name {
    private String FIELD_NAME = "name";
    private String value;

    public Name(String value) {
        if(ValidateData.string(value, FIELD_NAME)){
            this.value = value;
        }
    }

    public String getValue(){ return value; }
}
