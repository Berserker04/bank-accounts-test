package com.bank.account;

import com.bank.account.services.AccountService;
import com.bank.http.ResponseHandler;
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

    private static final Logger logger = LoggerFactory.getLogger(AccountController.class);
    @PostMapping()
    public ResponseEntity<?> createAccount(@RequestBody Account account) {
        logger.info("Account: creating new account");
        try {
            SecurityContextHolder.getContext().getAuthentication();

            Account result = accountService.createAccount(account).block();

            if(result == null) return ResponseHandler.success( "Can't register account");
            return ResponseHandler.success("Success", mapper.toEntityData(result).block(), HttpStatus.CREATED);
        }catch (IllegalArgumentException e){
            logger.info(e.getMessage());
            return ResponseHandler.success(e.getMessage());
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

            if(result == null) return ResponseHandler.success( "account not found");
            return ResponseHandler.success("Success", mapper.toEntityData(result).block());
        }catch (IllegalArgumentException e){
            logger.info(e.getMessage());
            return ResponseHandler.success(e.getMessage());
        }catch (Exception e){
            logger.info(e.getMessage());
            return ResponseHandler.error("Internal server error");
        }
    }

    @DeleteMapping("/{accountNumber}")
    public ResponseEntity<?> deleteAccount(@PathVariable Long accountNumber) {
        logger.info("Account: deleting account {}", accountNumber);
        try {
            SecurityContextHolder.getContext().getAuthentication();

            boolean result = accountService.deleteAccount(accountNumber).block();

            if(!result) return ResponseHandler.success( "Could not delete account");
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
