package com.bank.client;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface ClientDataRepository extends ReactiveCrudRepository<ClientData, Long> {
}
