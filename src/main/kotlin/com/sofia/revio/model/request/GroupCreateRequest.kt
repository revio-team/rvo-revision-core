package com.sofia.revio.model.request

import com.sofia.revio.model.Group

data class GroupCreateRequest(
    val name: String,
    var creatorUsername: String,
    val active: Boolean,
    val totemsPerGroup: Number,
    val users: ArrayList<String>? = null,
)

fun GroupCreateRequest.toGroup(): Group {
    return Group(null, name, creatorUsername, active, totemsPerGroup, users)
}