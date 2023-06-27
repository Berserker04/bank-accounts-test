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
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
public class MovementUseCaseImp implements MovementUseCase {
    private final MovementRepository movementRepository;
    private final AccountRepository accountRepository;

    private static final String MOVEMENT_TYPE_D = "Deposito";

    @Override
    public Mono<Movement> createMovement(Movement movement) {
        return accountRepository.findByAccountNumber(movement.getAccountId().getValue())
            .map(account -> {
                account.setInitialBalance(getNewBalance(account, movement));
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
        Flux<Movement> xd = movementRepository.getMovementAll();
        List<Movement> xd2 = xd.collect(Collectors.toList()).block();
        return xd;
    }

    @Override
    public Mono<Boolean> deleteMovement(Long id) {
        return movementRepository.deleteById(id);
    }

    private InitialBalance getNewBalance(Account account, Movement movement){
        double balance;

        if(movement.getMovementType().getValue().equalsIgnoreCase(MOVEMENT_TYPE_D))
            balance = account.getInitialBalance().getValue() + movement.getValue().getValue();
        else
            balance = account.getInitialBalance().getValue() - movement.getValue().getValue();

        movement.setBalance(new Balance(balance));
        return new InitialBalance(balance);
    }
}
