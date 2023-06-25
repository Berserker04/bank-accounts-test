package com.bank.client.services;

import com.bank.client.Client;
import com.bank.client.gatewey.in.ClientUseCase;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class ClientService implements ClientUseCase {

    private final ClientUseCase clientUseCase;

    public ClientService(ClientUseCase clientUseCase) {
        this.clientUseCase = clientUseCase;
    }

    @Override
    public Mono<Client> createClient(Client client) {
        System.out.println("passsssssssssssssssse por aquí");
        return clientUseCase.createClient(client);
    }

    @Override
    public Mono<Client> getClientById(Long id) {
        return clientUseCase.getClientById(id);
    }

    @Override
    public Mono<Client> updateClient(Long id, Client client) {
        return clientUseCase.updateClient(id, client);
    }

    @Override
    public Mono<Boolean> deleteClient(Long id) {
        return clientUseCase.deleteClient(id);
    }
}
