package com.bank.account;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Data
@Builder(toBuilder = true)
@Table(name = "accounts")
public class AccountData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column("id")
    private Long id;
    @Column("accountNumber")
    private Long accountNumber;
    @Column("accountType")
    private String accountType;
    @Column("initialBalance")
    private double initialBalance;
    private String state;
}
