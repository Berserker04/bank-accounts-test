package com.bank.account.properties;

import com.bank.commons.ValidateData;

public class AccountNumber {
    private String FIELD_NAME = "accountNumber";
    private Long value;

    public AccountNumber(Long value) {
        if(ValidateData.number(value, FIELD_NAME)){
            this.value = value;
        }
    }

    public Long getValue(){ return value; }
}
