package org.pbreakers.dmospring.dao

import org.pbreakers.dmospring.entities.Societe
import org.pbreakers.dmospring.entities.Transaction
import org.springframework.data.mongodb.repository.ReactiveMongoRepository
import reactor.core.publisher.Flux

interface TransactionRepository : ReactiveMongoRepository<Transaction, String> {
    fun findBySociete(societe: Societe): Flux<Transaction>
}