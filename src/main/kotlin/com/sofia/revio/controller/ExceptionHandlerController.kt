package com.sofia.revio.controller

import com.sofia.revio.exception.InactiveGroupException
import com.sofia.revio.model.request.ErrorMessage
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler

@ControllerAdvice
class ExceptionHandlerController {

    @ExceptionHandler
    fun handleRuntimeException(exception: InactiveGroupException) : ResponseEntity<ErrorMessage>{
        val errorMessage = ErrorMessage(
            HttpStatus.NOT_FOUND.value(),
            exception.message
        )
        return ResponseEntity(errorMessage, HttpStatus.NOT_FOUND)
    }
}