package com.bank.client;

import com.bank.client.gatewey.in.ClientUseCase;
import com.bank.client.gatewey.out.ClientRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class ClientUseCaseImp implements ClientUseCase {
    private final ClientRepository clientRepository;

    @Override
    public Mono<Client> createClient(Client client) {
        return clientRepository.save(client);
    }

    @Override
    public Mono<Client> getClientById(Long id) {
        return clientRepository.findById(id);
    }

    @Override
    public Mono<Client> updateClient(Client client) {
        return clientRepository.update(client);
    }

    @Override
    public Mono<Boolean> deleteClient(Long id) {
        return clientRepository.deleteById(id);
    }
}
