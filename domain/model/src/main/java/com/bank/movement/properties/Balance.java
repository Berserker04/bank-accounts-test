package com.bank.movement.properties;

import com.bank.commons.ValidateData;

public class Balance {
    private static String FIELD_NAME = "balance";
    private Double value;

    public Balance(Double value) {
        if(ValidateData.number(value, FIELD_NAME)){
            this.value = value;
        }
    }

    public Double getValue(){ return value; }
}
