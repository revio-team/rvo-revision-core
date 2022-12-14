package com.sofia.revio.controller

import com.sofia.revio.model.Group
import com.sofia.revio.model.Totem
import com.sofia.revio.model.request.GroupCreateRequest
import com.sofia.revio.model.request.RevisersUsernameRequest
import com.sofia.revio.service.GroupService
import feign.Response
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestHeader
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/v1/groups")
class GroupController(
    private val groupService: GroupService
) {

    @PostMapping
    fun createGroup(
        @RequestHeader username: String,
        @RequestBody groupCreateRequest: GroupCreateRequest
    ): ResponseEntity<Group> {
        return ResponseEntity(groupService.createGroup(groupCreateRequest, username), HttpStatus.CREATED)
    }

    @GetMapping("/{groupId}")
    fun getGroup(
        @PathVariable groupId: String,
        @RequestHeader username: String
    ): ResponseEntity<Group> {
        return ResponseEntity.ok(groupService.getGroup(groupId))
    }

    @PostMapping("/{groupId}/activate")
    fun activateGroup(
        @PathVariable groupId: String,
        @RequestHeader username: String
    ): ResponseEntity<Any> {
        groupService.activateGroup(groupId)
        return ResponseEntity.accepted().build()
    }
    @DeleteMapping("/{groupId}")
    fun removeGroup(
        @PathVariable groupId: String,
        @RequestHeader username: String
    ): ResponseEntity<Any> {
        groupService.removeGroup(groupId)
        return ResponseEntity.accepted().build()
    }

}