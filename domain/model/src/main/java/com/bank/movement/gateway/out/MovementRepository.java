package com.bank.movement.gateway.out;

import com.bank.movement.Movement;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.LocalDate;

public interface MovementRepository {
    Mono<Movement> save(Movement movement);
    Flux<Movement> getMovementByClientId(Long id);
    Flux<Movement> getMovementAll();
    Mono<Movement> getBalanceCurrentDay(Long accountId, LocalDate currentDay);
}
