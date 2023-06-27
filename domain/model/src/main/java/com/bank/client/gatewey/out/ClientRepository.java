package com.bank.client.gatewey.out;

import com.bank.client.Client;
import reactor.core.publisher.Mono;

public interface ClientRepository {
    Mono<Client> save(Client client);
    Mono<Client> findById(Long id);
    Mono<Client> findByClientId(Long clientId);
    Mono<Integer> update(Client client);
    Mono<Boolean> deleteById(Long clientId);
}
