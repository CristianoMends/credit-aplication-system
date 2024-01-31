package com.example.creditapplication.exception

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.annotation.ExceptionHandler
import java.time.LocalDateTime

class BusinessException(s: String) : RuntimeException(s) {

    @ExceptionHandler(BusinessException::class)
    fun handlerValidException(ex: MethodArgumentNotValidException): ResponseEntity<ExceptionDetails> {
        return ResponseEntity.status(HttpStatus.CONFLICT).body(
            ExceptionDetails(
                title = "Bad Request! consult the documentation",
                timestamp = LocalDateTime.now(),
                status = HttpStatus.BAD_REQUEST.value(),
                exception = ex.objectName.toString(),
                details = mutableMapOf(ex.cause.toString() to ex.message)
            )
        )
    }
}
