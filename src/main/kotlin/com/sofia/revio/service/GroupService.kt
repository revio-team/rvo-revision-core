package com.sofia.revio.service

import com.sofia.revio.exception.GroupNotFoundException
import com.sofia.revio.exception.InactiveGroupException
import com.sofia.revio.model.Group
import com.sofia.revio.model.request.GroupCreateRequest
import com.sofia.revio.model.request.RevisersUsernameRequest
import com.sofia.revio.model.request.toGroup
import com.sofia.revio.repository.GroupRepository
import org.springframework.stereotype.Service

@Service
class GroupService(
    private val groupRepository: GroupRepository
) {

    fun createGroup(groupCreateRequest: GroupCreateRequest, username: String): Group {
        groupCreateRequest.creatorUsername = username
        val group = groupCreateRequest.toGroup()
        return groupRepository.save(group)
    }

    fun addToGroup(revisers: RevisersUsernameRequest, groupId: String): Group {
        val group = groupRepository.findById(groupId).orElseThrow {
            throw GroupNotFoundException("Group not found")
        }
        if(group.active.not()){
            throw InactiveGroupException("Group now allowed to receive members. Current state is inactive")
        }
        group.users?.addAll(revisers.users)
        return groupRepository.save(group)
    }

    fun getGroup(groupId: String): Group {
        return groupRepository.findById(groupId).get()
    }

    fun removeGroup(groupId: String): Group {
        val group = groupRepository.findById(groupId).get()
        if(group.active.not()){
            throw InactiveGroupException("Group current state is inactive")
        }
        group.active = false

        return groupRepository.save(group)
    }
}