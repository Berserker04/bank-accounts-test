package com.bank.health;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/v1/health")
public class HealthController {
    @GetMapping
    public Mono<String> getHealth(){
        return Mono.just("server working successfully");
    }
}
