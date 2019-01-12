package com.danielbostwick.catfacts.core.persistence

import com.danielbostwick.catfacts.core.model.CatFact
import com.danielbostwick.catfacts.core.type.UUID

interface CatFactRepository {

    fun add(fact: CatFact)

    fun remove(factId: UUID)

    fun get(factId: UUID): CatFact?

    fun getAll(): List<CatFact>
}
