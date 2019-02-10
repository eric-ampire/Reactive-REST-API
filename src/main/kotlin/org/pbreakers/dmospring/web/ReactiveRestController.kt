package org.pbreakers.dmospring.web

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestBody
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

interface ReactiveRestController<T> {
    fun findAll(): Flux<T>
    fun findOne(@PathVariable id: String): Mono<T>
    fun delete(@PathVariable id: String): Mono<Void>
    fun update(@RequestBody item: T, @PathVariable id: String): Mono<T>
    fun save(@RequestBody item: T): Mono<T>
}