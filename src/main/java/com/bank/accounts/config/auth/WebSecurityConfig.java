package com.bank.accounts.config.auth;

import com.bank.auth.filter.JwtRequestFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
public class WebSecurityConfig {


    @Autowired
    private JwtRequestFilter jwtRequestFilter;
    @Bean
    SecurityFilterChain web(HttpSecurity http) throws Exception {
        http.csrf(csrfConfig -> csrfConfig.disable())
            .authorizeHttpRequests((authorize) -> authorize
                    .requestMatchers("/public/**").permitAll()
                    .requestMatchers("/api/v1/auth/**").permitAll()
                    .requestMatchers("/api/v1/clients/**").authenticated()
                    .requestMatchers("/api/v1/accounts/**").authenticated()
                    .requestMatchers("/api/v1/movements/**").authenticated()
                    .requestMatchers("/api/v1/reports/**").authenticated()
                    .requestMatchers("/admin/**").hasRole("ADMIN")
                    .requestMatchers(HttpMethod.POST, "/api/v1/clients").hasRole("ADMIN")
                    .anyRequest().authenticated()
            )
            .cors(withDefaults())
            .addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class)
            .sessionManagement((session) -> session
                    .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
            );
        return http.build();
    }

    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    AuthenticationManager authenticationManager(AuthenticationConfiguration
                                                        authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }

}

