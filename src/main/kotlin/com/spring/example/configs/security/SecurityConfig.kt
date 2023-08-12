package com.spring.example.configs.security

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.web.SecurityFilterChain

@Configuration
@EnableWebSecurity
class SecurityConfig(
    private val authenticationProvider: CustomAuthenticationProvider,
    private val successHandler: CustomAuthenticationSuccessHandler,
    private val failureHandler: CustomAuthenticationFailureHandler
) {
    @Bean
    fun filterChain(http: HttpSecurity): SecurityFilterChain {
        http.authorizeHttpRequests { authorize ->
            authorize
                .requestMatchers("/").permitAll()
                .requestMatchers("/login").permitAll()
                .requestMatchers("/accounts/**").hasAuthority("READ")
                .anyRequest().authenticated()
        }
            .authenticationProvider(authenticationProvider)
            .httpBasic { }
            .formLogin { config ->
                config
                    .loginPage("/login")
                    .successHandler(successHandler)
                    .failureHandler(failureHandler)
            }
            .logout { }

        return http.build()
    }
}