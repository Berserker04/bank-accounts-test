package com.bank.account;

import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public interface AccountDataRepository extends ReactiveCrudRepository<AccountData, Long> {
    Mono<AccountData> findByAccountNumber(Long accountNumber);

    @Query("UPDATE accounts SET state = 'False' WHERE accountNumber = :?")
    Mono<Integer> deleteAccount(Long accountNumber);
}
