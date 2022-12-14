package com.sofia.revio.model

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import java.time.LocalDateTime

@Document
data class Totem (
    @Id val id: String?,
    val name: String,
    val groupId: String,
    var active: Boolean = true,
    val createdAt: LocalDateTime = LocalDateTime.now(),
    var lastUpdatedAt: LocalDateTime = LocalDateTime.now()
)