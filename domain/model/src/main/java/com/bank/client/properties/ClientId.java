package com.bank.client.properties;

import com.bank.commons.ValidateData;

public class ClientId {
    private String FIELD_NAME = "clientId";
    private String value;

    public ClientId(String value) {
        if(ValidateData.string(value, FIELD_NAME)){
            this.value = value;
        }
    }

    public String getValue(){ return value; }
}
