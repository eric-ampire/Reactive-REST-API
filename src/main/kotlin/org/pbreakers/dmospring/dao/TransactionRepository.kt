package org.pbreakers.dmospring.dao

import org.pbreakers.dmospring.entities.Transaction
import org.springframework.data.mongodb.repository.ReactiveMongoRepository

interface TransactionRepository : ReactiveMongoRepository<Transaction, String>