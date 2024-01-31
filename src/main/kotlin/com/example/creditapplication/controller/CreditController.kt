package com.example.creditapplication.controller

import com.example.creditapplication.dto.CreditDto
import com.example.creditapplication.dto.CreditView
import com.example.creditapplication.dto.CreditViewList
import com.example.creditapplication.entity.Credit
import com.example.creditapplication.service.impl.CreditService
import jakarta.validation.Valid
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import java.util.*
import java.util.stream.Collectors

@RestController
@RequestMapping("/api/credits")
class CreditController(private val creditService: CreditService
) {
    @PostMapping
    fun saveCredit(@RequestBody @Valid creditDto: CreditDto): ResponseEntity<String>{
        val credit: Credit = this.creditService.save(creditDto.toEntity())
        //retornando um response
        return ResponseEntity.status(HttpStatus.CREATED).body("Credito ${credit.creditCode} - Cliente ${credit.customer?.firstName} salvo!")
    }

    @GetMapping
    fun findAllByCustomerId(@RequestParam(value = "customerId") customerId: Long): ResponseEntity<List<CreditViewList>>{
        val creditViewList:List<CreditViewList> =  this.creditService.findAllByCustomer(customerId)
            .stream()
            .map { credit: Credit -> CreditViewList(credit) }
            .collect(Collectors.toList())
        return ResponseEntity.status(HttpStatus.OK).body(creditViewList)
    }

    @GetMapping("/{creditCode}")
    fun findByCreditCode(@RequestParam(value = "customerId") customerId:Long,
                         @PathVariable creditCode: UUID) : ResponseEntity<CreditView> {
        val credit: Credit = this.creditService.findByCreditCode(customerId, creditCode)
        return ResponseEntity.status(HttpStatus.OK).body(CreditView(credit))
    }
}