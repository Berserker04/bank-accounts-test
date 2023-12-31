package com.bank.movement;

import com.bank.movement.gateway.out.MovementRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.LocalDate;

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
    public Flux<Movement> getMovementByClientId(Long clientId) {
        return repository.findByClientId(clientId)
                .map(mapper::toDomainModel);
    }

    @Override
    public Flux<Movement> getMovementAll() {
        return repository.findAll()
                .map(mapper::toDomainModel);
    }

    @Override
    public Mono<Movement> getBalanceCurrentDay(Long accountId, LocalDate cunrrenDay) {
        return repository.findBytBalanceCurrentDay(accountId, cunrrenDay)
                .map(mapper::toDomainModel);
    }
}
