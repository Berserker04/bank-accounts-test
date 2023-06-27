package com.bank.movement.dto;

import com.bank.movement.properties.Value;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BalanceMoved {
    private Value value;
    public BalanceMoved(Value value) {
        this.value = value;
    }
}
