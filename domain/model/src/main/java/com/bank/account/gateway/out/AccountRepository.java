package com.bank.account.gateway.out;

import com.bank.account.Account;
import reactor.core.publisher.Mono;

public interface AccountRepository {
    Mono<Account> save(Account account);
    Mono<Account> findByAccountNumber(Long accountNumber);
    Mono<Account> updateBalance(Account account);
    Mono<Boolean> deleteAccount(Long accountNumber);
}
