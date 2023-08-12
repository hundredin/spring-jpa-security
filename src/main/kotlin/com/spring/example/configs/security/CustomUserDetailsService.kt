package com.spring.example.configs.security

import com.spring.example.persistence.repositories.AccountRepository
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.stereotype.Component

@Component
class CustomUserDetailsService(private val accountRepository: AccountRepository) : UserDetailsService {
    override fun loadUserByUsername(username: String): UserDetails {
        val account = accountRepository.findByUsername(username)
            ?: throw UsernameNotFoundException("Not found user")

        return SecurityUser(account)
    }
}