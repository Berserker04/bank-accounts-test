package com.bank.commons.properties;

import com.bank.commons.ValidateData;

public class Id {
    private String FIELD_NAME = "id";
    private Long value;

    public Id(Long value) {
        if(ValidateData.number(value, FIELD_NAME)){
            this.value = value;
        }
    }

    public Long getValue(){ return value; }
}
