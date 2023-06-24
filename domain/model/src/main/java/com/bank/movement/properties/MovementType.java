package com.bank.movement.properties;

import com.bank.commons.ValidateData;

public class MovementType {
    private String FIELD_NAME = "movementType";
    private String value;

    public MovementType(String value) {
        if(ValidateData.string(value, FIELD_NAME)){
            this.value = value;
        }
    }

    public String getValue(){ return value; }
}
