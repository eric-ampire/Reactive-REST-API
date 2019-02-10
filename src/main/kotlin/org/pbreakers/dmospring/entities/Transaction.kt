package org.pbreakers.dmospring.entities

import lombok.NoArgsConstructor
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.DBRef
import org.springframework.data.mongodb.core.mapping.Document
import java.time.Instant

@Document
@NoArgsConstructor
data class Transaction(
    @Id
    var id: String,
    var price: Double,
    @DBRef
    var societe: Societe,
    var instant: Instant
)