package com.bank.movement;

import com.bank.commons.properties.Id;
import com.bank.movement.properties.Balance;
import com.bank.movement.properties.Date;
import com.bank.movement.properties.MovementType;
import com.bank.movement.properties.Value;
import reactor.core.publisher.Mono;

public class MovementMapper {
    public final Mono<MovementData> toEntityData(Movement movement) {
        return Mono.just(MovementData.builder()
                .id(movement.getId().getValue())
                .date(movement.getDate().getValue())
                .movementType(movement.getMovementType().getValue())
                .value(movement.getValue().getValue())
                .balance(movement.getBalance().getValue())
                .accountId(movement.getAccountId().getValue())
                .build());
    }

    public final Mono<MovementData> toNewEntityData(Movement movement) {
        return Mono.just(MovementData.builder()
                .date(movement.getDate().getValue())
                .movementType(movement.getMovementType().getValue())
                .value(movement.getValue().getValue())
                .balance(movement.getBalance().getValue())
                .accountId(movement.getAccountId().getValue())
                .build());
    }

    public final Movement toDomainModel(MovementData movementData) {
        return new Movement(
                new Id(movementData.getId()),
                new Date(movementData.getDate()),
                new MovementType(movementData.getMovementType()),
                new Value(movementData.getValue()),
                new Balance(movementData.getBalance()),
                new Id(movementData.getAccountId())
        );
    }
}
