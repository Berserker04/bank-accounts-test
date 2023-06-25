package com.bank.client;

import com.bank.client.gatewey.out.ClientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
@RequiredArgsConstructor
public class ClientRepositoryAdapter implements ClientRepository {

    private final ClientMapper mapper;
    private final ClientDataRepository repository;
    @Override
    public Mono<Client> save(Client client) {
        System.out.println("asta acá tambein <3");
        ClientData clientData = mapper.fromDomainModel(client);
        return Mono.just(client);
    }

    @Override
    public Mono<Client> findById(Long id) {
        return Mono.empty();
    }

    @Override
    public Mono<Client> update(Client client) {
        return Mono.empty();
    }

    @Override
    public Mono<Boolean> deleteById(Long id) {
        return Mono.empty();
    }
}
