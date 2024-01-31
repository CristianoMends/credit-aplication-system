package com.example.creditapplication.dto

import com.example.creditapplication.entity.Customer
import jakarta.validation.constraints.NotEmpty
import jakarta.validation.constraints.NotNull
import java.math.BigDecimal

data class CustomerUpdateDto(
    @field:NotEmpty(message = "invalid input") val firstName: String,
    @field:NotEmpty(message = "invalid input") val lastName: String,
    @field:NotNull(message = "invalid input") val income: BigDecimal,
    @field:NotEmpty(message = "invalid input") val zipCode: String,
    @field:NotEmpty(message = "invalid input") val street: String
) {
    fun toEntity(customer: Customer): Customer {
        customer.firstName = this.firstName
        customer.lastName = this.lastName
        customer.income = this.income
        customer.address.street = this.street
        customer.address.zipCode = this.zipCode
        return customer
    }
}
