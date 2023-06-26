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
        return Mono.just(client)
                .flatMap(mapper::toNewEntityData)
                .flatMap(repository::save)
                .map(mapper::toDomainModel);
    }

    @Override
    public Mono<Client> findByClientId(Long client) {
        return repository.findByClientId(client)
                .map(mapper::toDomainModel);
    }

    @Override
    public Mono<Client> update(Client client) {
        return repository.existsById(client.getId().getValue())
                .flatMap(exists -> {
                    if(exists){
                        return Mono.just(client)
                                .flatMap(mapper::toEntityData)
                                .flatMap(repository::save)
                                .map(mapper::toDomainModel);
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
