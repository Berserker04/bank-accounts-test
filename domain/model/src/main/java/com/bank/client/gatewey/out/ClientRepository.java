package com.bank.client.gatewey.out;

import com.bank.client.Client;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ClientRepository {
    Mono<Client> save(Client client);
    Mono<Client> findById(Long id);
//    Flux<Client> findAll();
    Mono<Integer> update(Client task);
    boolean deleteById(Long id);
}
