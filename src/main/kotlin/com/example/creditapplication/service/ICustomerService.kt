package com.example.creditapplication.service

import com.example.creditapplication.entity.Customer

interface ICustomerService {

    fun save(customer: Customer):Customer

    fun findById(id: Long): Customer

    fun delete(id: Long)
}