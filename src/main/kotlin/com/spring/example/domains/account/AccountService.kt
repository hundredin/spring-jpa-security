package com.spring.example.domains.account

import com.spring.example.persistence.entities.Account
import com.spring.example.persistence.repositories.AccountRepository
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service

@Service
class AccountService(private val accountRepository: AccountRepository) {
    fun getAccount(id: Long): Account {
        return accountRepository.findByIdOrNull(id) ?: throw Exception("Account not found")
    }

    fun getAllAccounts(): List<Account> {
        return accountRepository.findAll()
    }
}