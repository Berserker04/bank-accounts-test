package com.bank.movement;

import com.bank.movement.gateway.out.MovementRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class MovementRepositoryAdapter implements MovementRepository {

    private final MovementMapper mapper;
    private final MovementDataRepository repository;

    @Override
    public Mono<Movement> save(Movement movement) {
        return Mono.just(movement)
                .flatMap(mapper::toNewEntityData)
                .flatMap(repository::save)
                .map(mapper::toDomainModel);
    }

    @Override
    public Mono<Movement> findById(Long id) {
        return repository.findById(id)
                .map(mapper::toDomainModel);
    }

    @Override
    public Mono<Movement> update(Movement movement) {
        return repository.existsById(movement.getId().getValue())
                .flatMap(exists -> {
                    if(exists){
                        return Mono.just(movement)
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
