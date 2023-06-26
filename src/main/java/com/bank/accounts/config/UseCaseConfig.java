package com.bank.accounts.config;

import com.bank.account.AccountMapper;
import com.bank.account.AccountRepositoryAdapter;
import com.bank.account.AccountUseCaseImp;
import com.bank.account.gateway.out.AccountRepository;
import com.bank.account.services.AccountService;
import com.bank.client.ClientMapper;
import com.bank.client.ClientRepositoryAdapter;
import com.bank.client.ClientUseCaseImp;
import com.bank.client.gatewey.out.ClientRepository;
import com.bank.client.services.ClientService;
import com.bank.movement.MovementMapper;
import com.bank.movement.MovementRepositoryAdapter;
import com.bank.movement.MovementUseCaseImp;
import com.bank.movement.gateway.out.MovementRepository;
import com.bank.movement.services.MovementService;
import com.bank.report.ReportMapper;
import com.bank.report.ReportRepositoryAdapter;
import com.bank.report.ReportUseCaseImp;
import com.bank.report.gateway.out.ReportRepository;
import com.bank.report.services.ReportService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
public class UseCaseConfig {
    //Client
    @Bean
    public ClientMapper clientMapper(){
        return new ClientMapper();
    }

    @Bean("clientServicePrimary")
    @Primary
    public ClientService clientService(ClientRepository clientRepository, BCryptPasswordEncoder passwordEncoder) {
        return new ClientService(
                new ClientUseCaseImp(clientRepository, passwordEncoder)
        );
    }

    @Bean
    public ClientRepository clientRepository(ClientRepositoryAdapter clientRepositoryAdapter){
        return clientRepositoryAdapter;
    }

    //Account
    @Bean
    public AccountMapper accountMapper(){
        return new AccountMapper();
    }

    @Bean("accountServicePrimary")
    @Primary
    public AccountService accountService(AccountRepository accountRepository) {
        return new AccountService(
                new AccountUseCaseImp(accountRepository)
        );
    }

    @Bean
    public AccountRepository accountRepository(AccountRepositoryAdapter accountRepositoryAdapter){
        return accountRepositoryAdapter;
    }

    //Movement
    @Bean
    public MovementMapper movementMapper(){
        return new MovementMapper();
    }

    @Bean("movementServicePrimary")
    @Primary
    public MovementService movementService(MovementRepository movementRepository) {
        return new MovementService(
                new MovementUseCaseImp(movementRepository)
        );
    }

    @Bean
    public MovementRepository movementRepository(MovementRepositoryAdapter movementRepositoryAdapter){
        return movementRepositoryAdapter;
    }

    //Report
    @Bean
    public ReportMapper reportMapper(){
        return new ReportMapper();
    }

    @Bean("reportServicePrimary")
    @Primary
    public ReportService reportService(ReportRepository reportRepository) {
        return new ReportService(
                new ReportUseCaseImp(reportRepository)
        );
    }

    @Bean
    public ReportRepository reportRepository(ReportRepositoryAdapter reportRepositoryAdapter){
        return reportRepositoryAdapter;
    }
}
