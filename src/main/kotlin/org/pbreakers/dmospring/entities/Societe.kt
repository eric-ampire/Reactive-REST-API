package org.pbreakers.dmospring.entities

import lombok.NoArgsConstructor
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document
@NoArgsConstructor
data class Societe(
    @Id var id: String,
    var nom: String,
    var prix: Double
)