package com.bank.account;

import com.bank.client.Client;
import com.bank.client.services.ClientService;
import org.springframework.context.annotation.Lazy;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/client")
public class Account {

    private ClientService clientService;

    public Account(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping()
    public Mono<String> getTest() {
        return Mono.just("Todo bien todo correcto! <3 xxxxxxxxxx");
    }

    @PostMapping()
    public Mono<Client> createClient(@RequestBody Client client) {
        System.out.println("test 123");
        return clientService.createClient(client);
    }
}
