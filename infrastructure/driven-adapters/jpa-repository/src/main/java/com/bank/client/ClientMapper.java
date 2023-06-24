package com.bank.client;

import com.bank.client.properties.ClientId;
import com.bank.client.properties.Password;
import com.bank.commons.properties.Id;
import com.bank.commons.properties.State;
import com.bank.person.properties.*;

public class ClientMapper {
    public static ClientData fromDomainModel(Client client) {
        return ClientData.builder()
                .id(client.getId().getValue())
                .clientId(client.getClientId().getValue())
                .fullName(client.getFullName().getValue())
                .identification(client.getIdentification().getValue())
                .cellPhone(client.getCellPhone().getValue())
                .password(client.getPassword().getValue())
                .address(client.getAddress().getValue())
                .gender(client.getGender().getValue())
                .state(client.getState().getValue())
                .build();
    }

    public static Client toDomainModel(ClientData clientData) {
        return new Client(
                new Address(clientData.getAddress()),
                new CellPhone(clientData.getCellPhone()),
                new Gender(clientData.getGender()),
                new Id(clientData.getId()),
                new Identification(clientData.getIdentification()),
                new FullName(clientData.getFullName()),
                new ClientId(clientData.getClientId()),
                new Password(clientData.getPassword()),
                new State(clientData.getState()));
    }
}