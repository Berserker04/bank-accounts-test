package com.bank.report;

import com.bank.account.properties.AccountNumber;
import com.bank.account.properties.AccountType;
import com.bank.account.properties.InitialBalance;
import com.bank.commons.properties.State;
import com.bank.movement.properties.Balance;
import com.bank.movement.properties.Date;
import com.bank.movement.properties.Value;
import com.bank.person.properties.FullName;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Report {
    private Date date;
    private FullName client;
    private AccountNumber accountNumber;
    private AccountType accountType;
    private InitialBalance initialBalance;
    private State state;
    private Value value;
    private Balance balance;

    public Report(Date date, FullName client, AccountNumber accountNumber, AccountType accountType, InitialBalance initialBalance, State state, Value value, Balance balance) {
        this.date = date;
        this.client = client;
        this.accountNumber = accountNumber;
        this.accountType = accountType;
        this.initialBalance = initialBalance;
        this.state = state;
        this.value = value;
        this.balance = balance;
    }
}
