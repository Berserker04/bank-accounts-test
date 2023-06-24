package com.bank.account;

import com.bank.account.properties.AccountNumber;
import com.bank.account.properties.AccountType;
import com.bank.account.properties.InitialBalance;
import com.bank.commons.properties.Id;
import com.bank.commons.properties.State;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Account {
    private Id id;
    private AccountNumber accountNumber;
    private AccountType accountType;
    private InitialBalance initialBalance;
    private State state;

    public Account(Id id, AccountNumber accountNumber, AccountType accountType, InitialBalance initialBalance, State state) {
        this.id = id;
        this.accountNumber = accountNumber;
        this.accountType = accountType;
        this.initialBalance = initialBalance;
        this.state = state;
    }
}
