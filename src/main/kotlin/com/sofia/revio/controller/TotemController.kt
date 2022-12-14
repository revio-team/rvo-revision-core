package com.sofia.revio.controller

import com.sofia.revio.model.Totem
import com.sofia.revio.model.request.TotemCreateRequest
import com.sofia.revio.model.response.TotemResponse
import com.sofia.revio.service.TotemService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping("/v1/totem")
class TotemController(
    private val totemService: TotemService
) {
    @PostMapping
    fun createTotem(
        @RequestHeader username: String,
        @RequestBody totemCreateRequest: TotemCreateRequest,
    ): ResponseEntity<Totem> {
        return ResponseEntity(totemService.createTotem(totemCreateRequest), HttpStatus.CREATED)
    }

    @GetMapping("/{totemId}")
    fun getTotem(
        @PathVariable totemId: String,
        @RequestHeader username: String,
    ): ResponseEntity<TotemResponse> {
        return ResponseEntity.ok(totemService.getTotemDetails(totemId))
    }

    @PostMapping("/{totemId}/activate")
    fun activateTotem(
        @PathVariable totemId: String,
        @RequestHeader username: String,
    ): ResponseEntity<Any> {
        totemService.activateTotem(totemId)
        return ResponseEntity.accepted().build()
    }

    @DeleteMapping("/{totemId}")
    fun removeTotem(
        @PathVariable totemId: String,
        @RequestHeader username: String,
    ): ResponseEntity<Any> {
        totemService.removeTotem(totemId)
        return ResponseEntity.accepted().build()
    }

}