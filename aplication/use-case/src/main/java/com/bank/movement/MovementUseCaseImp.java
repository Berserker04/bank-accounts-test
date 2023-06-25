package com.bank.movement;

import com.bank.movement.gateway.in.MovementUseCase;
import com.bank.movement.gateway.out.MovementRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class MovementUseCaseImp implements MovementUseCase {
    private final MovementRepository movementRepository;

    @Override
    public Mono<Movement> createMovement(Movement movement) {
        return movementRepository.save(movement);
    }

    @Override
    public Mono<Movement> getMovementById(Long id) {
        return movementRepository.findById(id);
    }

    @Override
    public Mono<Movement> updateMovement(Movement movement) {
        return movementRepository.update(movement);
    }

    @Override
    public Mono<Boolean> deleteMovement(Long id) {
        return movementRepository.deleteById(id);
    }
}
