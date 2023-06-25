package com.bank.account;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface AccountDataRepository extends ReactiveCrudRepository<AccountData, Long> {
}
