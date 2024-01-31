package com.example.creditapplication.exception

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.validation.FieldError
import org.springframework.validation.ObjectError
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.bind.annotation.RestControllerAdvice
import java.time.LocalDateTime

@RestControllerAdvice
class RestExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException::class)
    fun handlerValidException(ex:MethodArgumentNotValidException): ResponseEntity<ExceptionDetails>{
        return ResponseEntity.status(HttpStatus.CONFLICT).body(
            ExceptionDetails(
                title = "Conflict! consult the documentation",
                timestamp = LocalDateTime.now(),
                status = HttpStatus.CONFLICT.value(),
                exception = ex.objectName.toString(),
                details = mutableMapOf(ex.cause.toString() to ex.message)
            )
        )
    }
}