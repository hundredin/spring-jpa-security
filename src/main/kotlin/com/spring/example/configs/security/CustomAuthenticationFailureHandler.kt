package com.spring.example.configs.security

import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse
import org.slf4j.LoggerFactory
import org.springframework.security.core.AuthenticationException
import org.springframework.security.web.authentication.AuthenticationFailureHandler
import org.springframework.stereotype.Component

@Component
class CustomAuthenticationFailureHandler: AuthenticationFailureHandler {
    private val logger = LoggerFactory.getLogger(CustomAuthenticationFailureHandler::class.java)
    override fun onAuthenticationFailure(
        request: HttpServletRequest,
        response: HttpServletResponse,
        exception: AuthenticationException
    ) {
        logger.info("Authentication failed with message: ${exception.message}")

        response.sendRedirect("/login?error")
    }

}