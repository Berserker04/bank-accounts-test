package com.bank.movement.gateway.in;

import com.bank.movement.Movement;
import reactor.core.publisher.Mono;

public interface MovementUseCase {
    Mono<Movement> createMovement(Movement movement);
    Mono<Movement> getMovementById(Long id);
    Mono<Movement> updateMovement(Movement movement);
    Mono<Boolean> deleteMovement(Long id);
}
