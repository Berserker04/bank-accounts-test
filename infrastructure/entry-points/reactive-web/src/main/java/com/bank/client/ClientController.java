package com.bank.client;

import com.bank.auth.DemoRest;
import com.bank.client.services.ClientService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import java.util.HashMap;
import java.util.Map;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/clients")
public class ClientController {
    private final ClientMapper mapper;
    private final ClientService clientService;
    private static final Logger logger = LoggerFactory.getLogger(DemoRest.class);

    @PostMapping()
    public ResponseEntity<?> createClient(@RequestBody Client client) {
        SecurityContextHolder.getContext().getAuthentication();

        return ResponseEntity.ok(clientService.createClient(client));
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getClientById(@PathVariable Long id) {
        SecurityContextHolder.getContext().getAuthentication();

        Map<String, ClientData> mensaje = new HashMap<>();
        mensaje.put("body", mapper.toEntityData(clientService.getClientById(id).block()).block());

        return ResponseEntity.ok(mensaje);
    }

    @PutMapping()
    public Mono<Client> updateClient(@RequestBody Client client) {
        return clientService.updateClient(client);
    }

    @DeleteMapping("/{id}")
    public Mono<Boolean> deleteClient(@PathVariable Long id) {
        return clientService.deleteClient(id);
    }
}
