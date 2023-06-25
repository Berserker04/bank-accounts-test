package com.bank.client;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientDataRepository extends ReactiveCrudRepository<ClientData, Long> {
}
