package com.bank.commons.properties;

import com.bank.commons.ValidateData;

public class Id {
    private String FIELD_NAME = "id";
    private String value;

    public Id(String value) {
        if(ValidateData.string(value, FIELD_NAME)){
            this.value = value;
        }
    }

    public String getValue(){ return value; }
}
