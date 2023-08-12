package com.spring.example.domains.account

import com.spring.example.persistence.entities.Account
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/accounts")
class AccountController(private val accountService: AccountService) {

    @GetMapping
    fun getAllAccounts(): List<Account> {
        return accountService.getAllAccounts()
    }

    @GetMapping("/{accountId}")
    fun getAccount(@PathVariable accountId: Long): Account {
        return accountService.getAccount(accountId)
    }
}