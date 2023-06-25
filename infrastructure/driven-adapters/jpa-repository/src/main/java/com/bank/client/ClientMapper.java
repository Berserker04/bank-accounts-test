package com.bank.client;

import com.bank.client.properties.ClientId;
import com.bank.client.properties.Password;
import com.bank.commons.properties.Id;
import com.bank.commons.properties.State;
import com.bank.person.properties.*;
import reactor.core.publisher.Mono;

public class ClientMapper {
    public final Mono<ClientData> toEntityData(Client client) {
        return Mono.just(ClientData.builder()
                .id(client.getId().getValue())
                .clientId(client.getClientId().getValue())
                .fullName(client.getFullName().getValue())
                .identification(client.getIdentification().getValue())
                .cellPhone(client.getCellPhone().getValue())
                .password(client.getPassword().getValue())
                .address(client.getAddress().getValue())
                .gender(client.getGender().getValue())
                .state(client.getState().getValue())
                .build());
    }

    public final Mono<ClientData> toNewEntityData(Client client) {
        return Mono.just(ClientData.builder()
                .clientId(client.getClientId().getValue())
                .fullName(client.getFullName().getValue())
                .identification(client.getIdentification().getValue())
                .cellPhone(client.getCellPhone().getValue())
                .password(client.getPassword().getValue())
                .address(client.getAddress().getValue())
                .gender(client.getGender().getValue())
                .state(client.getState().getValue())
                .build());
    }

    public final Client toDomainModel(ClientData clientData) {
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