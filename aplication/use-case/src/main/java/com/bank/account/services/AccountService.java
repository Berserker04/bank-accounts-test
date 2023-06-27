package com.bank.account.services;

import com.bank.account.Account;
import com.bank.account.gateway.in.AccountUseCase;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class AccountService implements AccountUseCase {
    private final AccountUseCase accountUseCase;
    @Override
    public Mono<Account> createAccount(Account account) {
        return accountUseCase.createAccount(account);
    }

    @Override
    public Mono<Account> getAccountByAccountNumber(Long accountNumber) {
        return accountUseCase.getAccountByAccountNumber(accountNumber);
    }

    @Override
    public Mono<Account> uptateBalance(Account account) {
        return accountUseCase.uptateBalance(account);
    }

    @Override
    public Mono<Boolean> deleteAccount(Long id) {
        return accountUseCase.deleteAccount(id);
    }
}
