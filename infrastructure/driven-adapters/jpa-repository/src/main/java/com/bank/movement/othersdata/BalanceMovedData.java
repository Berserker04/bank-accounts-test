package com.bank.movement.othersdata;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Data
@Builder(toBuilder = true)
@Table(name = "movements")
public class BalanceMovedData {
    @Column("balanceMoved ")
    private double balanceMoved;
}