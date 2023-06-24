package com.bank.person.properties;

import com.bank.commons.ValidateData;

public class Identification {
    private String FIELD_NAME = "identification";
    private Long value;

    public Identification(Long value) {
        if(ValidateData.number(value, FIELD_NAME)){
            this.value = value;
        }
    }

    public Long getValue(){ return value; }
}
