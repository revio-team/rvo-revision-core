package com.sofia.revio.repository

import com.sofia.revio.model.Group
import org.springframework.data.mongodb.repository.MongoRepository

interface GroupRepository: MongoRepository<Group, String>
