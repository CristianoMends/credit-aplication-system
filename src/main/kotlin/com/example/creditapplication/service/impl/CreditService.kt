package com.example.creditapplication.service.impl

import com.example.creditapplication.entity.Credit
import com.example.creditapplication.repository.CreditRepository
import com.example.creditapplication.service.ICreditService
import org.springframework.stereotype.Service
import java.util.*
@Service
class CreditService (
    private val creditRepository: CreditRepository,
    private val customerService: CustomerService
): ICreditService{
    override fun save(credit: Credit): Credit {
        credit.apply {
            customer = customerService.findById(credit.customer?.id!!)
        }
        return this.creditRepository.save(credit)
    }

    override fun findAllByCustomer(customerId: Long): List<Credit> = creditRepository.findAllByCustomerId(customerId)

    override fun findByCreditCode(customerId: Long,creditCode: UUID): Credit {
       val credit =  this.creditRepository.findByCreditCode(creditCode) ?: throw RuntimeException("CreditCode não encontrado!")
        return if (credit.customer?.id == customerId) credit else throw RuntimeException("Contate o admin")
    }

}