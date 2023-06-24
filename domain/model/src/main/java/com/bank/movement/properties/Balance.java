package com.bank.movement.properties;

import com.bank.commons.ValidateData;

public class Balance {
    private String FIELD_NAME = "balance";
    private String value;

    public Balance(String value) {
        if(ValidateData.string(value, FIELD_NAME)){
            this.value = value;
        }
    }

    public String getValue(){ return value; }
}
