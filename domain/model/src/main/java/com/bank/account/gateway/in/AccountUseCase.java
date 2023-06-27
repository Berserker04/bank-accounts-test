package com.bank.account.gateway.in;

import com.bank.account.Account;
import reactor.core.publisher.Mono;

public interface AccountUseCase {
    Mono<Account> createAccount(Account account);
    Mono<Account> getAccountByAccountNumber(Long accountNumber);
    Mono<Account> uptateBalance(Account account);
    Mono<Boolean> deleteAccount(Long id);
}
