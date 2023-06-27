package com.bank.report;

import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

import java.time.LocalDate;

@Repository
public interface ReportDataRepository extends ReactiveCrudRepository<ReportData, Long> {
    @Query("SELECT \n" +
            "m.date,\n" +
            "c.fullName,\n" +
            "a.accountNumber,\n" +
            "a.accountType,\n" +
            "a.initialBalance,\n" +
            "a.state,\n" +
            "m.value,\n" +
            "m.balance\n" +
            "FROM `movements` m \n" +
            "INNER JOIN accounts a ON m.account_id = a.id \n" +
            "INNER JOIN clients c ON a.client_id = c.id \n" +
            "WHERE m.date > :?\n" +
            "AND c.clientId = :?\n" +
            "AND a.state = :?")
    Flux<ReportData> getMovements(LocalDate date, Long idClient,  String accountStatus);
}
