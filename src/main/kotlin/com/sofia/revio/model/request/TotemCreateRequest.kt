package com.sofia.revio.model.request

import com.sofia.revio.model.Totem

data class TotemCreateRequest(
    val name: String,
    val groupId: String,
    val active: Boolean,
)

fun TotemCreateRequest.toTotem(): Totem {
    return Totem(null, name, groupId, active)
}