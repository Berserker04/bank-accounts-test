package com.bank.account.properties;

import com.bank.commons.ValidateData;

public class AccountType {
    private String FIELD_NAME = "accountType";
    private String value;

    public AccountType(String value) {
        if(ValidateData.string(value, FIELD_NAME)){
            this.value = value;
        }
    }

    public String getValue(){ return value; }
}
