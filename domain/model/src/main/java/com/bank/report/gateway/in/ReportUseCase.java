package com.bank.report.gateway.in;

import com.bank.report.Report;
import com.bank.report.enpointbody.ReportByDate;
import reactor.core.publisher.Flux;

public interface ReportUseCase {
    Flux<Report> getReportByDate(String date, ReportByDate reportByDate);
}
