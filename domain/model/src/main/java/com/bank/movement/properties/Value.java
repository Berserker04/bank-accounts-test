package com.bank.movement.properties;

import com.bank.commons.ValidateData;

public class Value {
    private String FIELD_NAME = "value";
    private Double value;

    public Value(Double value) {
        if(ValidateData.number(value, FIELD_NAME)){
            this.value = value;
        }
    }

    public Double getValue(){ return value; }
}
