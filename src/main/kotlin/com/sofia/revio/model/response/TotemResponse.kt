package com.sofia.revio.model.response

import com.sofia.revio.model.Group
import java.time.LocalDateTime

data class TotemResponse (
    val id: String,
    val name: String,
    val group: Group,
    var active: Boolean,
    val createdAt: LocalDateTime,
    val lastUpdatedAt: LocalDateTime
)