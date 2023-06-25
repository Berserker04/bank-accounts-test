package com.bank.report;

import com.bank.report.gateway.out.ReportRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;

import java.time.LocalDate;

@Component
@RequiredArgsConstructor
public class ReportRepositoryAdapter implements ReportRepository {
    private final ReportMapper mapper;
    private final ReportDataRepository repository;

    @Override
    public Flux<Report> getReportByDate(Long idClient, LocalDate date, String accountStatus) {
        return repository.getMovements(idClient, date, accountStatus)
                .map(mapper::toDomainModel);
    }
}
