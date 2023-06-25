package com.bank.account.properties;

import com.bank.commons.ValidateData;

public class InitialBalance {
    private static String FIELD_NAME = "initialBalance";
    private Double value;

    public InitialBalance(Double value) {
        if(ValidateData.number(value, FIELD_NAME)){
            this.value = value;
        }
    }

    public Double getValue(){ return value; }
}
