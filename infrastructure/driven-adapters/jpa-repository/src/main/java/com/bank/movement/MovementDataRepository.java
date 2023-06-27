package com.bank.movement;

import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public interface MovementDataRepository extends ReactiveCrudRepository<MovementData, Long> {

    @Query("SELECT m.* FROM movements m\n" +
            "INNER JOIN accounts a ON m.account_id = a.accountNumber\n" +
            "INNER JOIN clients c ON a.client_id = c.id\n" +
            "WHERE c.clientId = :?")
    Flux<MovementData> findByClientId(Long idClient);
}
