package com.bank.account;

import com.bank.account.gateway.in.AccountUseCase;
import com.bank.account.gateway.out.AccountRepository;
import com.bank.account.properties.AccountNumber;
import com.bank.client.gatewey.out.ClientRepository;
import com.bank.commons.properties.Id;
import com.bank.commons.properties.State;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

import java.util.Random;

@RequiredArgsConstructor
public class AccountUseCaseImp implements AccountUseCase {
    private final AccountRepository accountRepository;
    private final ClientRepository clientRepository;
    private static final int ACCOUNT_NUMBER_LENGTH = 11;

    @Override
    public Mono<Account> createAccount(Account account) {
        return clientRepository.findByClientId(account.getClientId().getValue())
            .flatMap(client -> {
                account.setAccountNumber(new AccountNumber(generateAccountNumber()));
                account.setState(new State("True"));
                account.setClientId(new Id(client.getId().getValue()));
                return accountRepository.save(account);
            });
    }

    @Override
    public Mono<Account> getAccountByAccountNumber(Long accountNuber) {
        return accountRepository.findByAccountNumber(accountNuber);
    }

    @Override
    public Mono<Account> uptateBalance(Account account) {
        return accountRepository.updateBalance(account);
    }

    @Override
    public Mono<Boolean> deleteAccount(Long id) {
        return accountRepository.deleteAccount(id);
    }

    public static Long generateAccountNumber() {
        Random random = new Random();
        StringBuilder sb = new StringBuilder();
        while (sb.length() < ACCOUNT_NUMBER_LENGTH) {
            int digit = random.nextInt(ACCOUNT_NUMBER_LENGTH);
            sb.append(digit);
        }
        return Long.valueOf(sb.toString());
    }
}
