package com.bank.accounts.config;

import com.bank.client.*;
import com.bank.client.gatewey.out.ClientRepository;
import com.bank.client.services.ClientService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

@Configuration
@EnableJpaRepositories
public class UseCaseConfig {
    @Bean
    public ClientMapper clientMapper(){
        return new ClientMapper();
    }

//    @Bean
//    public TaskRepositoryPort taskRepositoryPort(JpaTaskRepositoryAdapter jpaTaskRepositoryAdapter) {
//        return jpaTaskRepositoryAdapter;
//    }

//    @Bean("clientDataRepositoryprimary")
//    @Primary
//    public ReactiveCrudRepository clientDataRepository(ReactiveCrudRepository<ClientData, Long> reactiveCrudRepository) {
//        // Instantiate and return the implementation of the repository (if needed)
//        return reactiveCrudRepository;
//    }

    @Bean("clientServicePrimary")
    @Primary
    public ClientService clientService(ClientRepository clientRepository) {
        return new ClientService(
                new ClientUseCaseImp(clientRepository)
        );
    }

//    @Bean("clientRepositoryAdapterPrimary")
//    @Primary
//    public ClientRepositoryAdapter clientRepositoryAdapter(ClientMapper clientMapper, ClientDataRepository clientDataRepository){
//        return new ClientRepositoryAdapter(
//                clientMapper, clientDataRepository
//        );
//    }

    @Bean
    public ClientRepository clientRepository(ClientRepositoryAdapter clientRepositoryAdapter){
        return clientRepositoryAdapter;
    }
}
