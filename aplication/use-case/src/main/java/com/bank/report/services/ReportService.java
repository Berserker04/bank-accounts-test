package com.bank.report.services;

import com.bank.report.Report;
import com.bank.report.enpointbody.ReportByDate;
import com.bank.report.gateway.in.ReportUseCase;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;

@RequiredArgsConstructor
public class ReportService implements ReportUseCase {
    private final ReportUseCase reportUseCase;
    @Override
    public Flux<Report> getReportByDate(String date, ReportByDate reportByDate) {
        return reportUseCase.getReportByDate(date, reportByDate);
    }
}
