package com.sofia.revio.controller

import com.sofia.revio.model.Group
import com.sofia.revio.model.request.RevisersUsernameRequest
import com.sofia.revio.service.GroupService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/v1/groups")
class GroupReviserController (
    private val groupService: GroupService
){

    @PostMapping("/{groupId}/reviser")
    fun addRevisersGroup(
        @PathVariable groupId: String,
        @RequestHeader username: String,
        @RequestBody revisersList: RevisersUsernameRequest
    ): ResponseEntity<Group> {
        return ResponseEntity.ok(groupService.addToGroup(revisersList, groupId))
    }

    @DeleteMapping("/{groupId}/reviser")
    fun removeRevisersGroup(
        @PathVariable groupId: String,
        @RequestHeader username: String,
        @RequestBody revisersList: RevisersUsernameRequest
    ): ResponseEntity<Group> {
        return ResponseEntity.ok(groupService.removeFromGroup(revisersList, groupId))
    }
}