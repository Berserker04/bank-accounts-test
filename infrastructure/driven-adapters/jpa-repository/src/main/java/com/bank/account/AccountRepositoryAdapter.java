package com.bank.account;

import com.bank.account.gateway.out.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class AccountRepositoryAdapter implements AccountRepository {

    private final AccountMapper mapper;
    private final AccountDataRepository repository;

    @Override
    public Mono<Account> save(Account account) {
        return Mono.just(account)
                .flatMap(mapper::toNewEntityData)
                .flatMap(repository::save)
                .map(mapper::toDomainModel);
    }

    @Override
    public Mono<Account> findById(Long id) {
        return repository.findById(id)
                .map(mapper::toDomainModel);
    }

    @Override
    public Mono<Account> update(Account account) {
        return repository.existsById(account.getId().getValue())
                .flatMap(exists -> {
                    if(exists){
                        return Mono.just(account)
                                .flatMap(mapper::toEntityData)
                                .flatMap(repository::save)
                                .map(mapper::toDomainModel);
                    }
                    return Mono.empty();
                });
    }

    @Override
    public Mono<Boolean> deleteById(Long id) {
        return repository.existsById(id)
                .flatMap(exists -> {
                    if(exists){
                        repository.deleteById(id).subscribe();
                        return Mono.just(true);
                    }
                    return Mono.just(false);
                });
    }
}
