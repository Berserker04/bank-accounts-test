package com.bank.movement;

import com.bank.account.Account;
import com.bank.account.gateway.out.AccountRepository;
import com.bank.account.properties.InitialBalance;
import com.bank.commons.properties.Id;
import com.bank.movement.gateway.in.MovementUseCase;
import com.bank.movement.gateway.out.MovementRepository;
import com.bank.movement.properties.Balance;
import com.bank.movement.properties.Date;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.LocalDate;

@RequiredArgsConstructor
public class MovementUseCaseImp implements MovementUseCase {
    private final MovementRepository movementRepository;
    private final AccountRepository accountRepository;

    private static final String MOVEMENT_TYPE_R = "Retiro";
    private static final double MAX_LIMIT_FOR_DAY = 1000000;

    @Override
    public Mono<Movement> createMovement(Movement movement) {
        return accountRepository.findByAccountNumber(movement.getAccountId().getValue())
            .flatMap(account ->  validateWithdrawalLimit(account,  movement))
            .map(account -> {
                InitialBalance initialBalance = getNewBalance(account, movement);

                if(initialBalance.getValue() < 0){
                    throw new IllegalArgumentException("Saldo insuficiente");
                }

                account.setInitialBalance(initialBalance);
                accountRepository.updateBalance(account).subscribe();

                movement.setAccountId(new Id(account.getId().getValue()));
                movement.setDate(new Date(LocalDate.now()));

                return movement;
            }).flatMap(movementRepository::save);
    }

    @Override
    public Flux<Movement> getMovementByClientId(Long clienId) {
        return movementRepository.getMovementByClientId(clienId);
    }

    @Override
    public Flux<Movement> getMovementAll() {
        return movementRepository.getMovementAll();
    }

    private InitialBalance getNewBalance(Account account, Movement movement){
        double balance;
        if(movement.getMovementType().getValue().equalsIgnoreCase(MOVEMENT_TYPE_R))
            balance = account.getInitialBalance().getValue() - movement.getValue().getValue();
        else
            balance = account.getInitialBalance().getValue() + movement.getValue().getValue();
        movement.setBalance(new Balance(balance));
        return new InitialBalance(balance);
    }

    private Mono<Account> validateWithdrawalLimit(Account account, Movement movement){
        if(!movement.getMovementType().getValue().equalsIgnoreCase(MOVEMENT_TYPE_R)) return Mono.just(account);
        return movementRepository.getBalanceCurrentDay(account.getId().getValue(), LocalDate.now())
            .map(banlance -> {
                if (banlance.getValue().getValue() + movement.getValue().getValue() > MAX_LIMIT_FOR_DAY)
                    throw new IllegalArgumentException("Limite de movimientos por dia alcanzado");
                return account;
            } );
    }
}
