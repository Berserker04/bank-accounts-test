package com.bank.client;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;


public interface ClientDataRepository extends JpaRepository<ClientData, Long> {
}
