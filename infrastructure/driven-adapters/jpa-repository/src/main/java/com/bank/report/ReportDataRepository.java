package com.bank.report;

import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

import java.time.LocalDate;

@Repository
public interface ReportDataRepository extends ReactiveCrudRepository<ReportData, Long> {
    @Query("SELECT * from movements")
    Flux<ReportData> getMovements(Long idClient, LocalDate date, String accountStatus);
}
