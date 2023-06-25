package com.bank.report.gateway.out;

import com.bank.report.Report;
import reactor.core.publisher.Flux;

import java.time.LocalDate;

public interface ReportRepository {
    Flux<Report> getReportByDate(Long idClient, LocalDate date, String accountStatus);
}
