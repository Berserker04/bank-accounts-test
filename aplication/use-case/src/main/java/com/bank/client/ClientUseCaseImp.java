package com.bank.client;

import com.bank.client.gatewey.in.ClientUseCase;
import com.bank.client.gatewey.out.ClientRepository;
import com.bank.client.properties.ClientId;
import com.bank.client.properties.Password;
import com.bank.client.properties.Role;
import com.bank.commons.properties.State;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import reactor.core.publisher.Mono;

import java.util.Random;

@RequiredArgsConstructor
public class ClientUseCaseImp implements ClientUseCase {
    private final ClientRepository clientRepository;

    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private static final int ACCOUNT_NUMBER_LENGTH = 10;

    @Override
    public Mono<Client> createClient(Client client) {
        String encodePassword = encryptPassword(client.getPassword().getValue());
        client.setPassword(new Password(encodePassword));
        client.setClientId(new ClientId(generateClientId()));
        client.setState(new State("True"));
        client.setRole(new Role("CLIENT"));
        return clientRepository.save(client);
    }

    @Override
    public Mono<Client> getClientByClientId(Long id) {
        return clientRepository.findByClientId(id);
    }

    @Override
    public Mono<Client> updateClient(Client client) {
        String encodePassword = encryptPassword(client.getPassword().getValue());
        client.setPassword(new Password(encodePassword));
        return clientRepository.update(client)
                .flatMap(result-> {
                    if(result >= 1){
                        return clientRepository.findById(client.getId().getValue());
                    }
                    return null;
                });
    }

    @Override
    public Mono<Boolean> deleteClient(Long clientId) {
        return clientRepository.deleteById(clientId);
    }

    public String encryptPassword(String password) {
        return  bCryptPasswordEncoder.encode(password);
    }

    public static Long generateClientId() {
        Random random = new Random();
        StringBuilder sb = new StringBuilder();
        while (sb.length() < ACCOUNT_NUMBER_LENGTH) {
            int digit = random.nextInt(10);
            sb.append(digit);
        }
        return Long.valueOf(sb.toString());
    }
}
