package com.bank.movement.gateway.out;

import com.bank.movement.Movement;
import reactor.core.publisher.Mono;

public interface MovementRepository {
    Mono<Movement> save(Movement movement);
    Mono<Movement> findById(Long id);
    Mono<Movement> update(Movement movement);
    Mono<Boolean> deleteById(Long id);
}
