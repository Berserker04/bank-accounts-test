package com.bank.report;

import com.bank.commons.properties.Id;
import com.bank.commons.properties.State;
import com.bank.movement.properties.Date;
import com.bank.report.enpointbody.ReportByDate;
import com.bank.report.gateway.in.ReportUseCase;
import com.bank.report.gateway.out.ReportRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;

@RequiredArgsConstructor
public class ReportUseCaseImp implements ReportUseCase {
    private final ReportRepository reportRepository;

    @Override
    public Flux<Report> getReportByDate(String dateString, ReportByDate reportByDate) {
        Id idClient = new Id(reportByDate.getIdClient().getValue());
        Date dateRange = new Date(dateString);
        State accountSatus = new State(reportByDate.getAccountStatus().getValue());
        return reportRepository.getReportByDate(idClient.getValue(), dateRange.getValue(), accountSatus.getValue());
    }

}
