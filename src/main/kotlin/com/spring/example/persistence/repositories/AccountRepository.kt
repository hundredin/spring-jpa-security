package com.spring.example.persistence.repositories

import com.spring.example.persistence.entities.Account
import org.springframework.data.jpa.repository.JpaRepository

interface AccountRepository: JpaRepository<Account, Long> {
    fun findByUsername(username: String): Account?
}