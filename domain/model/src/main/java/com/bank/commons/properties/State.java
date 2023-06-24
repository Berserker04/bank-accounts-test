package com.bank.commons.properties;

import com.bank.commons.ValidateData;

public class State {
    private String FIELD_NAME = "state";
    private String value;

    public State(String value) {
        if(ValidateData.string(value, FIELD_NAME)){
            this.value = value;
        }
    }

    public String getValue(){ return value; }
}
