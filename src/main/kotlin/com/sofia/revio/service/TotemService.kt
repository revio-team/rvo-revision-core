package com.sofia.revio.service

import com.sofia.revio.exception.InactiveItemException
import com.sofia.revio.exception.ItemNotFoundException
import com.sofia.revio.model.Totem
import com.sofia.revio.model.request.TotemCreateRequest
import com.sofia.revio.model.request.toTotem
import com.sofia.revio.model.response.TotemResponse
import com.sofia.revio.repository.TotemRepository
import org.springframework.stereotype.Service
import java.time.LocalDateTime


@Service
class TotemService(
    private val groupService: GroupService,
    private val totemRepository: TotemRepository,
) {
    fun createTotem(totemCreateRequest: TotemCreateRequest): Totem {
        val totem = totemCreateRequest.toTotem()
        return totemRepository.save(totem)
    }

    fun getTotemDetails(totemId: String): TotemResponse {
        val totem = getTotem(totemId)
        val group = groupService.getGroup(totem.groupId)
        return TotemResponse(
            totem.id!!,
            totem.name,
            group,
            totem.active,
            totem.createdAt,
            totem.lastUpdatedAt
        )
    }

    fun getTotem(totemId: String): Totem {
        return totemRepository.findById(totemId).orElseThrow {
            throw ItemNotFoundException("Totem not found")
        }
    }

    fun activateTotem(totemId: String): Totem {
        val totem = getTotem(totemId)

        if (totem.active) {
            throw InactiveItemException("Totem current state is active")
        }
        totem.active = true
        totem.lastUpdatedAt = LocalDateTime.now()

        return totemRepository.save(totem)
    }

    fun removeTotem(totemId: String): Totem {
        val totem = getTotem(totemId)

        if (totem.active.not()) {
            throw InactiveItemException("Totem current state is inactive")
        }
        totem.active = false
        totem.lastUpdatedAt = LocalDateTime.now()

        return totemRepository.save(totem)
    }

}
