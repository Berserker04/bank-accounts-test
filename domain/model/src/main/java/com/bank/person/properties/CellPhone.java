package com.bank.person.properties;

import com.bank.commons.ValidateData;

public class CellPhone {
    private String FIELD_NAME = "cellPhone";
    private String value;

    public CellPhone(String value) {
        if(ValidateData.string(value, FIELD_NAME)){
            this.value = value;
        }
    }

    public String getValue(){ return value; }
}
