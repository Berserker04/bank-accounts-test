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
    public Mono<Client> findById(Long id) {
        return repository.findById(id)
                .map(mapper::toDomainModel);
    }

    @Override
    public Mono<Client> findByClientId(Long client) {
        return repository.findByClientId(client)
                .map(mapper::toDomainModel);
    }

    @Override
    public Mono<Integer> update(Client client) {
        return repository.existsById(client.getId().getValue())
                .flatMap(exists -> {
                    if(exists){
                        return Mono.just(client)
                                .flatMap(mapper::toUpdateEntityData)
                                .flatMap(c->{
                                    repository.updateFieldsByClientId(
                                            c.getPassword(),
                                            c.getAddress(),
                                            c.getCellPhone(),
                                            c.getGender(),
                                            c.getId()
                                    )
                                            .subscribe(integer -> {
                                                System.out.println(integer);
                                            });

                                    return Mono.just(1);
                                });
                    }
                    return Mono.empty();
                });
    }

    @Override
    public Mono<Boolean> deleteById(Long clientId) {
        return repository.findByClientId(clientId)
                .flatMap(client -> {
                    if(client != null){
                        repository.deleteClient(clientId).subscribe();
                        return Mono.just(true);
                    }
                    return Mono.just(false);
                });
    }
}
