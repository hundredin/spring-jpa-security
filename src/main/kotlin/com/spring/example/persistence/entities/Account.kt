package com.spring.example.persistence.entities

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id

@Entity
class Account(
    val username: String,
    val password: String,
    val authority: String,
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) val id: Long? = null
)