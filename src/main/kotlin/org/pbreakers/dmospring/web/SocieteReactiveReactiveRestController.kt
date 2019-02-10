package org.pbreakers.dmospring.web

import org.pbreakers.dmospring.dao.SocieteRepository
import org.pbreakers.dmospring.entities.Societe
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@RestController
class SocieteReactiveReactiveRestController : ReactiveRestController<Societe> {
    @Autowired
    private lateinit var societeRepository: SocieteRepository

    @GetMapping(value = "/societes")
    override fun findAll(): Flux<Societe> {
        return societeRepository.findAll()
    }

    @GetMapping(value = "/societes/{id}")
    override fun findOne(id: String): Mono<Societe> {
        return societeRepository.findById(id)
    }

    @DeleteMapping(value = "/societes/{id}")
    override fun delete(id: String): Mono<Void> {
        return societeRepository.deleteById(id)
    }

    @PutMapping(value = "/societes/{id}")
    override fun update(item: Societe, id: String): Mono<Societe> {
        item.id = id
        return societeRepository.save(item)
    }

    @PostMapping(value = "/societes")
    override fun save(item: Societe): Mono<Societe> {
        return societeRepository.save(item)
    }
}