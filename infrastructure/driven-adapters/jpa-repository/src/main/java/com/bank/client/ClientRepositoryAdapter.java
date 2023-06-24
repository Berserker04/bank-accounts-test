package com.bank.client;

import com.bank.client.gatewey.out.ClientRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public class ClientRepositoryAdapter implements ClientRepository {

    private final ClientMapper mapper;
    private final ClientDataRepository repository;

    public ClientRepositoryAdapter(ClientMapper mapper, ClientDataRepository repository) {
        this.mapper = mapper;
        this.repository = repository;
    }

    @Override
    public Mono<Client> save(Client client) {
        ClientData clientData = mapper.fromDomainModel(client);
        Mono<ClientData> savedData = repository.save(clientData);
        return savedData.map(d->mapper.toDomainModel(d));
    }

    @Override
    public Mono<Client> findById(Long id) {
        return repository.findById(id)
                .map(d->mapper.toDomainModel(d));
    }

    @Override
    public Mono<Client> update(Client client) {
        return repository.existsById(client.getId().getValue())
                .flatMap(exists -> {
                    if(exists){
                        ClientData clientData =  mapper.fromDomainModel(client);
                        Mono<ClientData> updatedClientData = repository.save(clientData);
                        return updatedClientData.map(d->mapper.toDomainModel(d));
                    }
                    return Mono.empty();
                });
    }

    @Override
    public Mono<Boolean> deleteById(Long id) {
        return repository.existsById(id)
                .flatMap(exists -> {
                    if(exists){
                        repository.deleteById(id);
                        return Mono.just(true);
                    }
                    return Mono.just(false);
                });
    }
}
