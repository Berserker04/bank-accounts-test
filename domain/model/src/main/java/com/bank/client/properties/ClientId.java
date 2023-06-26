package com.bank.client.properties;

import com.bank.commons.ValidateData;

public class ClientId {
    private static String FIELD_NAME = "clientId";
    private Long value;

    public ClientId(Long value) {
        if(ValidateData.number(value, FIELD_NAME)){
            this.value = value;
        }
    }

    public ClientId(String value) {
        if(ValidateData.string(value, FIELD_NAME)){
            this.value = Long.valueOf(value);
        }
    }

    public Long getValue(){ return value; }
}
