package com.example.enanospeleadores2.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http
                // No sesiones
                .csrf(csrf -> csrf.disable())

                // No login por formulario
                .formLogin(form -> form.disable())

                // No HTTP basic
                .httpBasic(basic -> basic.disable())

                // Autorización de endpoints
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/api/peleadores/**").authenticated()
                        .requestMatchers("/api/peleas/**").authenticated()
                        .anyRequest().permitAll()
                )

                // JWT desde Keycloak
                .oauth2ResourceServer(oauth2 -> oauth2
                        .jwt(Customizer.withDefaults())
                );

        return http.build();
    }
}
