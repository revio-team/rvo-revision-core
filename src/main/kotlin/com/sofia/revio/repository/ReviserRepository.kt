package com.sofia.revio.repository

import com.sofia.revio.model.Reviser
import org.springframework.data.mongodb.repository.MongoRepository
import java.util.Optional

interface ReviserRepository: MongoRepository<Reviser, String> {
    fun findByTotemIdAndActive(totemId: String, active: Boolean): Optional<Reviser>
}
