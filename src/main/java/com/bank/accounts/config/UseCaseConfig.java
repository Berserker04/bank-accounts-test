package com.bank.accounts.config;

import com.bank.client.*;
import com.bank.client.gatewey.out.ClientRepository;
import com.bank.client.services.ClientService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.r2dbc.repository.config.EnableR2dbcRepositories;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

@Configuration
public class UseCaseConfig {
    @Bean
    public ClientMapper clientMapper(){
        return new ClientMapper();
    }

    @Bean("clientServicePrimary")
    @Primary
    public ClientService clientService(ClientRepository clientRepository) {
        return new ClientService(
                new ClientUseCaseImp(clientRepository)
        );
    }

    @Bean
    public ClientRepository clientRepository(ClientRepositoryAdapter clientRepositoryAdapter){
        return clientRepositoryAdapter;
    }
}
