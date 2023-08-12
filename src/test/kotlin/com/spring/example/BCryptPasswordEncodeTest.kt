package com.spring.example

import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder

class BCryptPasswordEncodeTest: DescribeSpec({
    val passwordEncoder = BCryptPasswordEncoder()

    describe("bcryptPasswordEncoder") {
        it("encode") {
            val encrypted = passwordEncoder.encode("12345")

            encrypted shouldBe "\$2a\$10\$2AzBedLM2KXi80xbM6nqUOFjk8By96Ceo13k9IKLJcMo4P6qimrpO"
        }
    }
})