package com.bank.person.properties;

import com.bank.commons.ValidateData;

public class CellPhone {
    private String FIELD_NAME = "cellPhone";
    private Long value;

    public CellPhone(Long value) {
        if(ValidateData.number(value, FIELD_NAME)){
            this.value = value;
        }
    }

    public Long getValue(){ return value; }
}
