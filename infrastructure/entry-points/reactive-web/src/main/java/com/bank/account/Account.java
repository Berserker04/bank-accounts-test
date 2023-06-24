package com.bank.account;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/test")
public class Account {
    @GetMapping()
    public Mono<String> getTest() {
        return Mono.just("Todo bien todo correcto! <3 xxxxxxxxxx");
    }
}
