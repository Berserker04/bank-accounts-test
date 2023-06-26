package com.bank.client;

import com.bank.auth.DemoRest;
import com.bank.auth.service.ResponseHandler;
import com.bank.client.services.ClientService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
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
        try {
            SecurityContextHolder.getContext().getAuthentication();

//            ReactiveSecurityContextHolder.getContext()
//                    .map(securityContext -> securityContext.getAuthentication());

            Client result = clientService.createClient(client).block();

            if(result == null) return ResponseHandler.success("No se puedo registrar el client");
            return ResponseHandler.success("Success", mapper.toEntityData(result).block(), HttpStatus.CREATED);
        }catch (Exception e){
            logger.info(e.getMessage());
            return ResponseHandler.error("Internal server error");
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getClientById(@PathVariable Long id) {
        SecurityContextHolder.getContext().getAuthentication();

        Map<String, ClientData> mensaje = new HashMap<>();
        mensaje.put("body", mapper.toEntityData(clientService.getClientByClientId(id).block()).block());

        return ResponseEntity.ok(mensaje);


        //        try {
////            SecurityContextHolder.getContext().getAuthentication();
//
//            ReactiveSecurityContextHolder.getContext()
//                    .map(securityContext -> securityContext.getAuthentication());
//
//            Client xd =clientService.getClientById(id).block();
//
//            return clientService.getClientById(id)
//                .flatMap(mapper::toEntityData)
//                .map(client -> {
//                if(client == null){
//                    return ResponseHandler.success("Cliente " + id +" no existe");
//                }
//                return ResponseHandler
//                        .success("Success", client);
//            });
//        }catch (Exception e){
//            return Mono.just(ResponseHandler.error("Internal server error"));
//        }
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
