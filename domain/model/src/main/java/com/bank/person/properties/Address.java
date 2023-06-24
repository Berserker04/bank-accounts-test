package com.bank.person.properties;

import com.bank.commons.ValidateData;

public class Address {
    private String FIELD_NAME = "address";
    private String value;

    public Address(String value) {
        if(ValidateData.string(value, FIELD_NAME)){
            this.value = value;
        }
    }

    public String getValue(){ return value; }
}
