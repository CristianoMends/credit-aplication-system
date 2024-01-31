package com.example.creditapplication.dto

import com.example.creditapplication.entity.Address
import com.example.creditapplication.entity.Customer
import jakarta.validation.constraints.Email
import jakarta.validation.constraints.NotEmpty
import jakarta.validation.constraints.NotNull
import org.hibernate.validator.constraints.br.CPF
import java.math.BigDecimal

data class CustomerDto(
    @field:NotEmpty(message = "invalid input") val firstName: String,
    @field:NotEmpty(message = "invalid input") val lastName: String,
    @field:CPF(message = "invalid CPF") val cpf: String,
    @field: NotNull val income: BigDecimal,
    @field:Email(message = "invalid email") val email: String,
    @field:NotEmpty(message = "invalid input") val password: String,
    @field:NotEmpty(message = "invalid input") val zipCode: String,
    @field:NotEmpty(message = "invalid input") val Street: String
){
    fun toEntity(): Customer = Customer(
        firstName = this.firstName,
        lastName = this.lastName,
        cpf = this.cpf,
        income = this.income,
        email = this.email,
        password = this.password,
        address = Address(
            zipCode = this.zipCode,
            street = this.Street
        )
    )
}