package com.bank.account.gateway.out;

import com.bank.account.Account;
import reactor.core.publisher.Mono;

public interface AccountRepository {
    Mono<Account> save(Account account);
    Mono<Account> findById(Long id);
    Mono<Account> update(Account account);
    Mono<Boolean> deleteById(Long id);
}
