package com.bank.movement.properties;

import com.bank.commons.ValidateData;

public class Value {
    private String FIELD_NAME = "value";
    private String value;

    public Value(String value) {
        if(ValidateData.string(value, FIELD_NAME)){
            this.value = value;
        }
    }

    public String getValue(){ return value; }
}
