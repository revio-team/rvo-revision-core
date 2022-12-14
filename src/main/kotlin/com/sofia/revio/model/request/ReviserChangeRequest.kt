package com.sofia.revio.model.request

import com.sofia.revio.model.Reviser

data class ReviserChangeRequest(
    val currentReviser: String,
    val totemId: String,
    val active: Boolean,
)

fun ReviserChangeRequest.toReviser(): Reviser {
    return Reviser(null, currentReviser, totemId, active)
}