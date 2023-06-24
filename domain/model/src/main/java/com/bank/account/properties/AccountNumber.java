package com.bank.account.properties;

import com.bank.commons.ValidateData;

public class AccountNumber {
    private String FIELD_NAME = "accountNumber";
    private String value;

    public AccountNumber(String value) {
        if(ValidateData.string(value, FIELD_NAME)){
            this.value = value;
        }
    }

    public String getValue(){ return value; }
}
