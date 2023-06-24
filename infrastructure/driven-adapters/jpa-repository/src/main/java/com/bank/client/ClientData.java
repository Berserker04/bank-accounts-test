package com.bank.client;

import com.bank.person.properties.*;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder(toBuilder = true)
@Entity
@Table(name = "clients")
public class ClientData {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "clients_id")
    @SequenceGenerator(name="clients", sequenceName = "clients_id")
    private Long id;
    private Long clientId;
    private String password;
    private String state;
    private String address;
    private Long cellPhone;
    private String gender;
    private Long identification;
    private String fullName;
}