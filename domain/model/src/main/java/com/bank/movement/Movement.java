package com.bank.movement;

import com.bank.commons.properties.Id;
import com.bank.movement.properties.Balance;
import com.bank.movement.properties.Date;
import com.bank.movement.properties.MovementType;
import com.bank.movement.properties.Value;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Movement {
    private Id id;
    private Date date;
    private MovementType movementType;
    private Value value;
    private Balance balance;
    private Id accountId;

    public Movement(Id id, Date date, MovementType movementType, Value value, Balance balance, Id accountId) {
        this.id = id;
        this.date = date;
        this.movementType = movementType;
        this.value = value;
        this.balance = balance;
        this.accountId = accountId;
    }
}
