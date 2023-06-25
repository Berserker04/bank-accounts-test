package com.bank.account;

import com.bank.account.gateway.in.AccountUseCase;
import com.bank.account.gateway.out.AccountRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class AccountUseCaseImp implements AccountUseCase {
    private final AccountRepository accountRepository;

    @Override
    public Mono<Account> createAccount(Account account) {
        return accountRepository.save(account);
    }

    @Override
    public Mono<Account> getAccountById(Long id) {
        return accountRepository.findById(id);
    }

    @Override
    public Mono<Account> updateAccount(Account account) {
        return accountRepository.update(account);
    }

    @Override
    public Mono<Boolean> deleteAccount(Long id) {
        return accountRepository.deleteById(id);
    }
}
