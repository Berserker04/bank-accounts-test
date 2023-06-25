package com.bank.client;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder(toBuilder = true)
//@Entity
@Table(name = "clients")
public class ClientData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @GeneratedValue(strategy = GenerationType.AUTO, generator = "clients_id")
//    @SequenceGenerator(name="clients", sequenceName = "clients_id")
    @Column("id")
    private Long id;
    @Column("clientId")
    private Long clientId;
    private String password;
    private String state;
    private String address;
    @Column("cellPhone")
    private Long cellPhone;
    private String gender;
    private Long identification;
    @Column("fullName")
    private String fullName;
}