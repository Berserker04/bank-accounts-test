package com.bank.movement;

import com.bank.movement.services.MovementService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/movements")
public class MovementController {
    private final MovementService movementService;

    @PostMapping()
    public Mono<Movement> createMovement(@RequestBody Movement movement) {
        return movementService.createMovement(movement);
    }

    @GetMapping("/{id}")
    public Mono<Movement> getMovementById(@PathVariable Long id) {
        return movementService.getMovementById(id);
    }

    @PutMapping()
    public Mono<Movement> updateMovement(@RequestBody Movement movement) {
        return movementService.updateMovement(movement);
    }

    @DeleteMapping("/{id}")
    public Mono<Boolean> deleteMovement(@PathVariable Long id) {
        return movementService.deleteMovement(id);
    }
}
