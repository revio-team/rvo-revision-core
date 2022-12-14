package com.sofia.revio.service

import com.sofia.revio.exception.ItemNotFoundException
import com.sofia.revio.model.request.ReviserChangeRequest
import com.sofia.revio.model.request.toReviser
import com.sofia.revio.repository.ReviserRepository
import org.springframework.stereotype.Service

@Service
class ReviserService(
    private val reviserRepository: ReviserRepository,
    private val totemService: TotemService
) {
    fun nextReviser(reviserChangeRequest: ReviserChangeRequest) {
        val totem = totemService.getTotemDetails(reviserChangeRequest.totemId)
        val group = totem.group

        val hasUser =  group.users!!.contains(reviserChangeRequest.currentReviser)

        if(hasUser.not()){
            throw ItemNotFoundException("This user is not associated with totem group.")
        }

        val reviserOccurrence =
            reviserRepository.findByTotemIdAndActive(reviserChangeRequest.totemId, reviserChangeRequest.active)
                .orElse(null)
        if (reviserOccurrence != null) {

            reviserOccurrence.active = false
            reviserRepository.save(reviserOccurrence)
        }

        val reviser = reviserChangeRequest.toReviser()
        reviserRepository.save(reviser)
    }
}