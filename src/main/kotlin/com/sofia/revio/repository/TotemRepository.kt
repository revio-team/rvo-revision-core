package com.sofia.revio.repository

import com.sofia.revio.model.Totem
import org.springframework.data.mongodb.repository.MongoRepository

interface TotemRepository: MongoRepository<Totem, String>
