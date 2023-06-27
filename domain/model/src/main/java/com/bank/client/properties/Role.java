package com.bank.client.properties;

import com.bank.commons.ValidateData;

public class Role {
    private static String FIELD_NAME = "role";
    private String value;

    public Role(String value) {
        if(ValidateData.string(value, FIELD_NAME)){
            this.value = value;
        }
    }

    public String getValue(){ return value; }
}
