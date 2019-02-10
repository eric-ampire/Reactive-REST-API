package org.pbreakers.dmospring.dao

import org.pbreakers.dmospring.entities.Societe
import org.springframework.data.mongodb.repository.ReactiveMongoRepository

interface SocieteRepository : ReactiveMongoRepository<Societe, String>