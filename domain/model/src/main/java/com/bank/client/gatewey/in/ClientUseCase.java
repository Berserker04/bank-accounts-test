package com.bank.client.gatewey.in;

import com.bank.client.Client;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ClientUseCase {
    Mono<Client> createClient(Client client);
    Mono<Client> getClientById(Long id);
//    Flux<Client> getAllClient();
    Mono<Client> updateClient(Long id, Client client);
    boolean deleteClient(Long id);
}
