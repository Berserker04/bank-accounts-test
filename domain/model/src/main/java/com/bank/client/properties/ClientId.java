package com.bank.client.properties;

import com.bank.commons.ValidateData;

public class ClientId {
    private String FIELD_NAME = "clientId";
    private Long value;

    public ClientId(Long value) {
        if(ValidateData.number(value, FIELD_NAME)){
            this.value = value;
        }
    }

    public Long getValue(){ return value; }
}
