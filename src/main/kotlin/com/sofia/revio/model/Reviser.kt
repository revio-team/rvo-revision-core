package com.sofia.revio.model

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import java.time.LocalDateTime

@Document
data class Reviser(
    @Id
    val id: String?,
    val username: String,
    val totemId: String,
    var active: Boolean = false,
    var receivedAt: LocalDateTime = LocalDateTime.now()
)