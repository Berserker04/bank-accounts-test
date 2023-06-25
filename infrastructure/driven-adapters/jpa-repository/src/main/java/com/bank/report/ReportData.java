package com.bank.report;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDate;

@Data
@Builder(toBuilder = true)
@Table
public class ReportData {
    private LocalDate date;
    @Column("fullName")
    private String client;
    @Column("accountNumber")
    private Long accountNumber;
    @Column("accountType")
    private String accountType;
    @Column("initialBalance")
    private double initialBalance;
    private String state;
    private double value;
    private double balance;
}
