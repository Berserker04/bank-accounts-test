package com.bank.movement.services;

import com.bank.movement.Movement;
import com.bank.movement.gateway.in.MovementUseCase;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class MovementService implements MovementUseCase {
    private final MovementUseCase movementUseCase;

    @Override
    public Mono<Movement> createMovement(Movement movement) {
        return movementUseCase.createMovement(movement);
    }

    @Override
    public Mono<Movement> getMovementById(Long id) {
        return movementUseCase.getMovementById(id);
    }

    @Override
    public Mono<Movement> updateMovement(Movement movement) {
        return movementUseCase.updateMovement(movement);
    }

    @Override
    public Mono<Boolean> deleteMovement(Long id) {
        return movementUseCase.deleteMovement(id);
    }
}
