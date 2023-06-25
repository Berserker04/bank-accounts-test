package com.bank.client.gatewey.in;

import com.bank.client.Client;
import reactor.core.publisher.Mono;

public interface ClientUseCase {
    Mono<Client> createClient(Client client);
    Mono<Client> getClientById(Long id);
    Mono<Client> updateClient(Client client);
    Mono<Boolean> deleteClient(Long id);
}
