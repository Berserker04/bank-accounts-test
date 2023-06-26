package com.bank.account;

import com.bank.account.services.AccountService;
import com.bank.auth.DemoRest;
import com.bank.auth.service.ResponseHandler;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/accounts")
public class AccountController {
    private final AccountMapper mapper;
    private final AccountService accountService;

    private static final Logger logger = LoggerFactory.getLogger(DemoRest.class);
    @PostMapping()
    public ResponseEntity<?> createAccount(@RequestBody Account account) {
        try {
            SecurityContextHolder.getContext().getAuthentication();

            Account result = accountService.createAccount(account).block();

            if(result == null) return ResponseHandler.success("No se puedo registrar la cuenta");
            return ResponseHandler.success("Success", mapper.toEntityData(result).block(), HttpStatus.CREATED);
        }catch (Exception e){
            logger.info(e.getMessage());
            return ResponseHandler.error("Internal server error");
        }
    }

    @GetMapping("/{accountNumber}")
    public ResponseEntity<?> getAccountByAccountNumber(@PathVariable Long accountNumber) {
        try {
            SecurityContextHolder.getContext().getAuthentication();

            Account result = accountService.getAccountByAccountNumber(accountNumber).block();

            if(result == null) return ResponseHandler.success("Cuenta no registrada");
            return ResponseHandler.success("Success", mapper.toEntityData(result).block());
        }catch (Exception e){
            logger.info(e.getMessage());
            return ResponseHandler.error("Internal server error");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteAccount(@PathVariable Long id) {
        try {
            SecurityContextHolder.getContext().getAuthentication();

            boolean result = accountService.deleteAccount(id).block();

            if(!result) return ResponseHandler.success("No se pudo eliminar la cuenta");
            return ResponseHandler.success("Success");
        }catch (Exception e){
            logger.info(e.getMessage());
            return ResponseHandler.error("Internal server error");
        }
    }
}
