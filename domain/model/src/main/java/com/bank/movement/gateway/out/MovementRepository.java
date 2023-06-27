package com.bank.movement.gateway.out;

import com.bank.movement.Movement;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface MovementRepository {
    Mono<Movement> save(Movement movement);
    Flux<Movement> getMovementByClientId(Long id);
    Flux<Movement> getMovementAll();
}
