package com.sofia.revio.model

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import java.time.LocalDateTime

@Document
data class Group(
    @Id val id: String?,
    val name: String,
    val creatorUsername: String? = null,
    var active: Boolean = true,
    var users: ArrayList<String>? = null,
    val createdAt: LocalDateTime = LocalDateTime.now()
)
