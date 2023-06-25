package com.bank.client;

import com.bank.client.services.ClientService;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/v1/client")
public class ClientController {
    private ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @PostMapping()
    public Mono<Client> createClient(@RequestBody Client client) {
        System.out.println("test 123");
        return clientService.createClient(client);
    }

    @GetMapping("/{id}")
    public Mono<Client> getClientById(@PathVariable Long id) {
        return clientService.getClientById(id);
    }

    @PutMapping("/{id}")
    public Mono<Client> updateClient(@PathVariable Long id, @RequestBody Client client) {
        return clientService.updateClient(id, client);
    }

    @DeleteMapping("/{id}")
    public Mono<Boolean> deleteClient(@PathVariable Long id) {
        return clientService.deleteClient(id);
    }
}
