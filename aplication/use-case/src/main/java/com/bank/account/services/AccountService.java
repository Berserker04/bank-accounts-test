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
    public Mono<Account> getAccountById(Long id) {
        return accountUseCase.getAccountById(id);
    }

    @Override
    public Mono<Account> updateAccount(Account account) {
        return accountUseCase.updateAccount(account);
    }

    @Override
    public Mono<Boolean> deleteAccount(Long id) {
        return accountUseCase.deleteAccount(id);
    }
}
