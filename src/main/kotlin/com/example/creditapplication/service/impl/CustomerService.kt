package com.example.creditapplication.service.impl

import com.example.creditapplication.entity.Customer
import com.example.creditapplication.repository.CustomerRepository
import com.example.creditapplication.service.ICustomerService
import org.springframework.stereotype.Service

@Service
class CustomerService(
    private val customerRepository: CustomerRepository
) : ICustomerService {
    override fun save(customer: Customer): Customer = this.customerRepository.save(customer)

    override fun findById(id: Long): Customer =
        this.customerRepository.findById(id).orElseThrow{
            throw RuntimeException("Id $id não encontrado!")
        }


    override fun delete(id: Long) = customerRepository.deleteById(id)
}