package com.bank.client;

import com.bank.client.gatewey.in.ClientUseCase;
import com.bank.client.gatewey.out.ClientRepository;
import reactor.core.publisher.Mono;

public class ClientUseCaseImp implements ClientUseCase {
    private final ClientRepository clientRepository;

    public ClientUseCaseImp(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @Override
    public Mono<Client> createClient(Client client) {
        return clientRepository.save(client);
    }

    @Override
    public Mono<Client> getClientById(Long id) {
        return clientRepository.findById(id);
    }

    @Override
    public Mono<Client> updateClient(Long id, Client client) {
        return clientRepository.update(client);
    }

    @Override
    public Mono<Boolean> deleteClient(Long id) {
        return clientRepository.deleteById(id);
    }
}
