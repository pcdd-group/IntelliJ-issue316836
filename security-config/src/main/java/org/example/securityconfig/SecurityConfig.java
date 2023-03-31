package org.example.securityconfig;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

/**
 * @author pcdd
 */
@Configuration
// With this annotation, the red line disappears
// @EnableAutoConfiguration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        return httpSecurity
                .authorizeHttpRequests(o -> o
                        .requestMatchers("/home").permitAll()
                        .anyRequest().authenticated()
                )
                .csrf().disable()
                .sessionManagement(o -> o.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .build();
    }

}
