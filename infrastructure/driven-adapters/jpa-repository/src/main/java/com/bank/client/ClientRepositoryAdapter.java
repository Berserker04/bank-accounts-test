package com.bank.client;

import com.bank.client.gatewey.out.ClientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class ClientRepositoryAdapter implements ClientRepository {

    private final ClientMapper mapper;
    private final ClientDataRepository repository;
    @Override
    public Mono<Client> save(Client client) {
        ClientData clientData = mapper.toNewEntityData(client);
        return repository.save(clientData)
            .map(d->mapper.toDomainModel(d));
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
                        ClientData clientData =  mapper.toEntityData(client);
                        return repository.save(clientData)
                                .map(d->mapper.toDomainModel(d));
                    }
                    return Mono.empty();
                });
    }

    @Override
    public Mono<Boolean> deleteById(Long id) {
        return repository.existsById(id)
                .flatMap(exists -> {
                    if(exists){
                        repository.deleteById(id).subscribe();
                        return Mono.just(true);
                    }
                    return Mono.just(false);
                });
    }
}
