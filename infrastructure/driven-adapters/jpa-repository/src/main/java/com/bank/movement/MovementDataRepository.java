package com.bank.movement;

import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.LocalDate;

@Repository
public interface MovementDataRepository extends ReactiveCrudRepository<MovementData, Long> {

    @Query("SELECT m.* FROM movements m\n" +
            "INNER JOIN accounts a ON m.account_id = a.id\n" +
            "INNER JOIN clients c ON a.client_id = c.id\n" +
            "WHERE c.clientId = :?")
    Flux<MovementData> findByClientId(Long idClient);


    @Query("SELECT m.id, m.date, m.movementType, SUM(m.value) as value, m.balance, m.account_id " +
            "FROM movements m " +
            "WHERE m.account_id = :? " +
            "AND m.date = :? " +
            "AND m.movementType = 'Retiro'")
    Mono<MovementData> findBytBalanceCurrentDay(Long idClient, LocalDate cunrrenDay);

}
