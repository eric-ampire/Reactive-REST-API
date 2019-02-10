package org.pbreakers.dmospring

import org.pbreakers.dmospring.dao.SocieteRepository
import org.pbreakers.dmospring.dao.TransactionRepository
import org.pbreakers.dmospring.entities.Societe
import org.pbreakers.dmospring.entities.Transaction
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean
import java.time.Instant
import java.util.*

@SpringBootApplication
class DmoSpringApplication {

	@Bean
	fun start(societeRepo: SocieteRepository, transactionRepo: TransactionRepository): CommandLineRunner {
		val firm = listOf(
			Societe("go", "Google", 14000.0),
			Societe("fa", "Facebook", 134000.0),
			Societe("tw", "Twitter", 146000.0),
			Societe("jb", "Jetbrean", 914000.0)
		)

		return CommandLineRunner {
			// deleting society
			societeRepo.deleteAll().subscribe(null, null) {
				firm.asSequence().forEach {

					// saving new society
					societeRepo.save(it).subscribe { society ->

						// delete all transaction
						transactionRepo.deleteAll().subscribe(null, null) {
							for (a in 1..10) {
								val trans = Transaction(
									UUID.randomUUID().toString(),
									societe = society,
									price = (society.prix) * (1 + Math.random() * 12 - 6) / 100,
									instant = Instant.now()
								)

								transactionRepo.save(trans).subscribe(::println)
							}
						}
					}
				}
			}
		}
	}
}

fun main(args: Array<String>) {
	runApplication<DmoSpringApplication>(*args)
}

