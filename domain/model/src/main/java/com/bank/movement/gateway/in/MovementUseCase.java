package com.bank.movement.gateway.in;

import com.bank.movement.Movement;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface MovementUseCase {
    Mono<Movement> createMovement(Movement movement);
    Flux<Movement> getMovementByClientId(Long clientId);
    Flux<Movement> getMovementAll();
    Mono<Boolean> deleteMovement(Long id);
}
