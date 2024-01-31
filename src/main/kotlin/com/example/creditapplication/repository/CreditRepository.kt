/*
* Em Repository, vc cria a interface e em Service vc implementa os metodos dessa interface
* */
package com.example.creditapplication.repository

import com.example.creditapplication.entity.Credit
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository
import java.util.UUID

@Repository
interface CreditRepository: JpaRepository<Credit, Long>{
    fun findByCreditCode(creditCode: UUID):Credit?
    @Query(value = "select * from credit where customer_id = ?1", nativeQuery = true)
    fun findAllByCustomerId(customerId:Long): List<Credit>
}