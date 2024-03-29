package com.example.creditapplication.entity

import com.example.creditapplication.enumeration.Status
import jakarta.persistence.*
import java.math.BigDecimal
import java.time.LocalDate
import java.util.*
@Entity
@Table(name = "Credit")
data class Credit (
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) val id: Long? = null,
    @Column(nullable = false, unique = true)val creditCode:UUID = UUID.randomUUID(),
    @Column(nullable = false) val creditValue:BigDecimal = BigDecimal.ZERO,
    @Column(nullable = false) val dayFirstInstallment: LocalDate = LocalDate.now(),
    @Column(nullable = false) val numberInstallment: Int = 0,
    @Enumerated val status: Status = Status.IN_PROGRESS,
    @ManyToOne var customer:Customer? = null
)
