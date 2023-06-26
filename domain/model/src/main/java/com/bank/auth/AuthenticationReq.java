package com.bank.auth;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class AuthenticationReq implements Serializable {

    private static final long serialVersionUID = 1L;

    private String clientId;

    private String password;

    public AuthenticationReq(String clientId, String password) {
        this.clientId = clientId;
        this.password = password;
    }
}