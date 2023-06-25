package com.bank.movement;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovementDataRepository extends ReactiveCrudRepository<MovementData, Long> {
}
