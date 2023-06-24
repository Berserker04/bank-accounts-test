package com.bank.account.properties;

import com.bank.commons.ValidateData;

public class InitialBalance {
    private String FIELD_NAME = "initialBalance";
    private String value;

    public InitialBalance(String value) {
        if(ValidateData.string(value, FIELD_NAME)){
            this.value = value;
        }
    }

    public String getValue(){ return value; }
}
