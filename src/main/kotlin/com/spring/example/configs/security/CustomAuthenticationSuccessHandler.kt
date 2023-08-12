package com.spring.example.configs.security

import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse
import org.slf4j.LoggerFactory
import org.springframework.security.core.Authentication
import org.springframework.security.web.authentication.AuthenticationSuccessHandler
import org.springframework.stereotype.Component

@Component
class CustomAuthenticationSuccessHandler: AuthenticationSuccessHandler {
    private val logger = LoggerFactory.getLogger(CustomAuthenticationSuccessHandler::class.java)
    override fun onAuthenticationSuccess(
        request: HttpServletRequest,
        response: HttpServletResponse,
        authentication: Authentication
    ) {
        logger.info("Login success - {}", authentication.name)

        response.sendRedirect("/")
    }
}