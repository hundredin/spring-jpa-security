package com.spring.example.configs.security

import com.spring.example.persistence.entities.Account
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.core.userdetails.UserDetails

class SecurityUser(
    private val account: Account
) : UserDetails {
    override fun getAuthorities(): MutableList<out GrantedAuthority> {
        return mutableListOf(SimpleGrantedAuthority(account.authority))
    }

    override fun getPassword(): String {
        return account.password
    }

    override fun getUsername(): String {
        return account.username
    }

    override fun isAccountNonExpired(): Boolean {
        return true
    }

    override fun isAccountNonLocked(): Boolean {
        return true
    }

    override fun isCredentialsNonExpired(): Boolean {
        return true
    }

    override fun isEnabled(): Boolean {
        return true
    }
}