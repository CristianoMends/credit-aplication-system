package com.example.creditapplication.dto

import com.example.creditapplication.entity.Credit
import com.example.creditapplication.entity.Customer
import java.math.BigDecimal
import java.time.LocalDate

data class CreditDto(
    val creditValue: BigDecimal,
    val dayFirstOfInstallment: LocalDate,
    val numberOfInstallments: Int,
    val customerId: Long
) {
    fun toEntity(): Credit = Credit(
        creditValue = this.creditValue,
        dayFirstInstallment = this.dayFirstOfInstallment,
        numberInstallment = this.numberOfInstallments,
        customer = Customer(id = this.customerId)
    )
}
