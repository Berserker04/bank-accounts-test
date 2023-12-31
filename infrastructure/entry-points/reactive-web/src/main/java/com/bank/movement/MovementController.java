package com.bank.movement;

import com.bank.http.ResponseHandler;
import com.bank.movement.services.MovementService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/movements")
public class MovementController {
    private final MovementMapper mapper;
    private final MovementService movementService;
    private static final Logger logger = LoggerFactory.getLogger(MovementController.class);
    @PostMapping()
    public ResponseEntity<?> createMovement(@RequestBody Movement movement) {
        logger.info("Movement: creating new movement");
        try {
            SecurityContextHolder.getContext().getAuthentication();

            Movement result = movementService.createMovement(movement).block();

            if(result == null) return ResponseHandler.success("Can't register movement");
            return ResponseHandler.success("Success", mapper.toEntityData(result).block(), HttpStatus.CREATED);
        }catch (IllegalArgumentException e){
            logger.info(e.getMessage());
            return ResponseHandler.success(e.getMessage());
        }catch (Exception e){
            logger.info(e.getMessage());
            return ResponseHandler.error("Internal server error");
        }
    }

    @GetMapping()
    public ResponseEntity<?> getMovementByAll() {
        try {
            SecurityContextHolder.getContext().getAuthentication();

            List<MovementData> result = movementService.getMovementAll()
                    .flatMap(movement -> mapper.toEntityData(movement))
                    .collect(Collectors.toList()).block();

            if(result.size() == 0) return ResponseHandler.success("Movements not found");
            return ResponseHandler.success("Success", result);
        }catch (IllegalArgumentException e){
            logger.info(e.getMessage());
            return ResponseHandler.success(e.getMessage());
        }catch (Exception e){
            logger.info(e.getMessage());
            return ResponseHandler.error("Internal server error");
        }
    }

    @GetMapping("/{clientId}")
    public ResponseEntity<?> getMovementByClientId(@PathVariable Long clientId) {
        try {
            SecurityContextHolder.getContext().getAuthentication();

            List<MovementData> result = movementService.getMovementByClientId(clientId)
                    .flatMap(movement -> mapper.toEntityData(movement))
                    .collect(Collectors.toList()).block();

            if(result == null) return ResponseHandler.success("Movements not found");
            return ResponseHandler.success("Success", result);
        }catch (IllegalArgumentException e){
            logger.info(e.getMessage());
            return ResponseHandler.success(e.getMessage());
        }catch (Exception e){
            logger.info(e.getMessage());
            return ResponseHandler.error("Internal server error");
        }
    }
}
