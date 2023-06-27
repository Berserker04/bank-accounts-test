package com.bank.report;

import com.bank.account.properties.AccountNumber;
import com.bank.account.properties.AccountType;
import com.bank.account.properties.InitialBalance;
import com.bank.commons.properties.State;
import com.bank.movement.properties.Balance;
import com.bank.movement.properties.Date;
import com.bank.movement.properties.Value;
import com.bank.person.properties.FullName;
import reactor.core.publisher.Mono;

public class ReportMapper {
    public final Mono<ReportData> toEntityData(Report report) {
        return Mono.just(ReportData.builder()
                .date(report.getDate().getValue())
                .client(report.getClient().getValue())
                .accountNumber(report.getAccountNumber().getValue())
                .accountType(report.getAccountType().getValue())
                .initialBalance(report.getInitialBalance().getValue())
                .state(report.getState().getValue())
                .value(report.getValue().getValue())
                .balance(report.getBalance().getValue())
                .build());
    }

    public final Report toDomainModel(ReportData report) {
        return new Report(
                new Date(report.getDate()),
                new FullName(report.getClient()),
                new AccountNumber(report.getAccountNumber()),
                new AccountType(report.getAccountType()),
                new InitialBalance(report.getInitialBalance()),
                new State(report.getState()),
                new Value(report.getValue()),
                new Balance(report.getBalance())
        );
    }
}
