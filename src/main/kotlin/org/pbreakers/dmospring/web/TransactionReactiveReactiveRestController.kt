package org.pbreakers.dmospring.web

import org.pbreakers.dmospring.dao.TransactionRepository
import org.pbreakers.dmospring.entities.Transaction
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.*
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@RestController
class TransactionReactiveReactiveRestController : ReactiveRestController<Transaction> {
    @Autowired
    private lateinit var transactionRepository: TransactionRepository

    @GetMapping(value = "/transactions")
    override fun findAll(): Flux<Transaction> {
        return transactionRepository.findAll()
    }

    @GetMapping(value = "/streamTransactions", produces = [MediaType.TEXT_EVENT_STREAM_VALUE])
    fun findAllStream(): Flux<Transaction> {
        return transactionRepository.findAll()
    }

    @GetMapping(value = "/transactions/{id}")
    override fun findOne(id: String): Mono<Transaction> {
        return transactionRepository.findById(id)
    }

    @DeleteMapping(value = "/transactions/{id}")
    override fun delete(id: String): Mono<Void> {
        return transactionRepository.deleteById(id)
    }

    @PutMapping(value = "/transactions/{id}")
    override fun update(item: Transaction, id: String): Mono<Transaction> {
        item.id = id
        return transactionRepository.save(item)
    }

    @PostMapping(value = "/transactions")
    override fun save(item: Transaction): Mono<Transaction> {
        return transactionRepository.save(item)
    }
}