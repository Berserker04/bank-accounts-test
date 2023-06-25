package com.bank.account;

import com.bank.account.properties.AccountNumber;
import com.bank.account.properties.AccountType;
import com.bank.account.properties.InitialBalance;
import com.bank.commons.properties.Id;
import com.bank.commons.properties.State;
import reactor.core.publisher.Mono;

public class AccountMapper {
    public final Mono<AccountData> toEntityData(Account account) {
        return Mono.just(AccountData.builder()
                .id(account.getId().getValue())
                .accountNumber(account.getAccountNumber().getValue())
                .accountType(account.getAccountType().getValue())
                .initialBalance(account.getInitialBalance().getValue())
                .state(account.getState().getValue())
                .build());
    }

    public final Mono<AccountData> toNewEntityData(Account account) {
        return Mono.just(AccountData.builder()
                .accountNumber(account.getAccountNumber().getValue())
                .accountType(account.getAccountType().getValue())
                .initialBalance(account.getInitialBalance().getValue())
                .state(account.getState().getValue())
                .build());
    }

    public final Account toDomainModel(AccountData accountData) {
        return new Account(
                new Id(accountData.getId()),
                new AccountNumber(accountData.getAccountNumber()),
                new AccountType(accountData.getAccountType()),
                new InitialBalance(accountData.getInitialBalance()),
                new State(accountData.getState())
        );
    }
}
