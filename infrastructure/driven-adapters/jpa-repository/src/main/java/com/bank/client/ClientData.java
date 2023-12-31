package com.bank.client;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Data
@Builder(toBuilder = true)
@Table(name = "clients")
public class ClientData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column("id")
    private Long id;
    @Column("clientId")
    private Long clientId;
    @Column("fullName")
    private String fullName;
    private Long identification;
    private String address;
    @Column("cellPhone")
    private Long cellPhone;
    private String gender;
    private String password;
    private String role;
    private String state;
}