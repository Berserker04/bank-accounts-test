package com.bank.client;

import com.bank.client.properties.ClientId;
import com.bank.commons.properties.Id;
import com.bank.client.properties.Password;
import com.bank.commons.properties.State;
import com.bank.person.Person;
import com.bank.person.properties.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Client extends Person {
    private Id id;
    private ClientId clientId;
    private Password password;
    private State state;

    public Client(Address address, CellPhone cellPhone, Gender gender, Id id, Identification adIdentification, Name name, ClientId clientId, Password password, State state) {
        super(address, cellPhone, gender, adIdentification, name);
        this.id = id;
        this.clientId = clientId;
        this.password = password;
        this.state = state;
    }
}