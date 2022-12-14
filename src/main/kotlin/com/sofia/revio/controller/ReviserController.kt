package com.sofia.revio.controller

import com.sofia.revio.model.request.ReviserChangeRequest
import com.sofia.revio.service.ReviserService
import org.springframework.http.ResponseEntity

import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.bind.annotation.RequestHeader
import org.springframework.web.bind.annotation.RequestBody

@RestController
@RequestMapping("/v1/reviser")
class ReviserController(
    private val reviserService: ReviserService
) {
    @PostMapping("/forward/")
    fun activateTotem(
        @RequestHeader username: String,
        @RequestBody reviserChangeRequest: ReviserChangeRequest
    ): ResponseEntity<Any> {
        reviserService.nextReviser(reviserChangeRequest)
        return ResponseEntity.accepted().build()
    }
}