package com.bank.movement.services;

import com.bank.movement.Movement;
import com.bank.movement.gateway.in.MovementUseCase;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class MovementService implements MovementUseCase {
    private final MovementUseCase movementUseCase;

    @Override
    public Mono<Movement> createMovement(Movement movement) {
        return movementUseCase.createMovement(movement);
    }

    @Override
    public Flux<Movement> getMovementByClientId(Long clientId) {
        return movementUseCase.getMovementByClientId(clientId);
    }

    @Override
    public Flux<Movement> getMovementAll() {
        return movementUseCase.getMovementAll();
    }

    @Override
    public Mono<Boolean> deleteMovement(Long id) {
        return movementUseCase.deleteMovement(id);
    }
}
