package com.bank.client;

import com.bank.http.ResponseHandler;
import com.bank.client.services.ClientService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/clients")
public class ClientController {
    private final ClientMapper mapper;
    private final ClientService clientService;
    private static final Logger logger = LoggerFactory.getLogger(ClientController.class);

    @PostMapping()
    public ResponseEntity<?> createClient(@RequestBody Client client) {
        logger.info("Client: creating new client");
        try {
            SecurityContextHolder.getContext().getAuthentication();

            Client result = clientService.createClient(client).block();

            if(result == null) return ResponseHandler.success( "Can't register client");
            return ResponseHandler.success("Success", mapper.toEntityData(result).block(), HttpStatus.CREATED);
        }catch (IllegalArgumentException e){
            logger.info(e.getMessage());
            return ResponseHandler.success(e.getMessage());
        }catch (Exception e){
            logger.info(e.getMessage());
            return ResponseHandler.error("Internal server error");
        }
    }

    @GetMapping("/{clientId}")
    public ResponseEntity<?> getClientById(@PathVariable Long clientId) {
        try {
            SecurityContextHolder.getContext().getAuthentication();

            Client result = clientService.getClientByClientId(clientId).block();

            if(result == null) return ResponseHandler.success( "Client not found");
            return ResponseHandler.success("Success", mapper.toEntityData(result).block());
        }catch (IllegalArgumentException e){
            logger.info(e.getMessage());
            return ResponseHandler.success(e.getMessage());
        }catch (Exception e){
            logger.info(e.getMessage());
            return ResponseHandler.error("Internal server error");
        }
    }

    @PatchMapping()
    public ResponseEntity<?> updateClient(@RequestBody Client client) {
        try {
            SecurityContextHolder.getContext().getAuthentication();

            Client result = clientService.updateClient(client).block();

            if(result == null) return ResponseHandler.success( "Could not update client");
            return ResponseHandler.success("Success", mapper.toEntityData(result).block());
        }catch (IllegalArgumentException e){
            logger.info(e.getMessage());
            return ResponseHandler.success(e.getMessage());
        }catch (Exception e){
            logger.info(e.getMessage());
            return ResponseHandler.error("Internal server error");
        }
    }

    @DeleteMapping("/{clientId}")
    public ResponseEntity<?> deleteClient(@PathVariable Long clientId) {
        logger.info("Client: deleting client {}", clientId);
        try {
            SecurityContextHolder.getContext().getAuthentication();

            Boolean result = clientService.deleteClient(clientId).block();

            if(!result) return ResponseHandler.success( "Can't delete client");
            return ResponseHandler.success("Success");
        }catch (IllegalArgumentException e){
            logger.info(e.getMessage());
            return ResponseHandler.success(e.getMessage());
        }catch (Exception e){
            logger.info(e.getMessage());
            return ResponseHandler.error("Internal server error");
        }

    }
}
