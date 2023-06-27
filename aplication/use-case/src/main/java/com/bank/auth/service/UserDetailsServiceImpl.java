package com.bank.auth.service;

import com.bank.client.Client;
import com.bank.client.gatewey.out.ClientRepository;
import com.bank.client.properties.ClientId;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {
    private final ClientRepository clientRepository;
    @Override
    public UserDetails loadUserByUsername(String clientId) throws UsernameNotFoundException {

        Client user = clientRepository.findByClientId(new ClientId(clientId).getValue()).block();

        if (user == null) {
            throw new UsernameNotFoundException(clientId);
        }
        return User
                .withUsername(clientId)
                .password(user.getPassword().getValue())
                .roles(user.getRole().getValue())
                .build();
    }

}
