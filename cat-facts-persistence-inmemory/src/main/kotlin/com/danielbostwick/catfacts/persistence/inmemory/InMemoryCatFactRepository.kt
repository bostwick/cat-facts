package com.danielbostwick.catfacts.persistence.inmemory

import com.danielbostwick.catfacts.core.Fixtures
import com.danielbostwick.catfacts.core.model.CatFact
import com.danielbostwick.catfacts.core.persistence.CatFactRepository
import com.danielbostwick.catfacts.core.type.UUID

class InMemoryCatFactRepository : CatFactRepository {
    override fun add(fact: CatFact) {
        Data.facts.add(fact)
    }

    override fun get(factId: UUID): CatFact? {
        return Data.facts.find { it.id == factId }
    }

    override fun getAll(): List<CatFact> {
        return Data.facts.toList()
    }

    override fun remove(factId: UUID) {
        Data.facts.removeIf { it.id == factId }
    }

    fun loadFixtures() {
        Fixtures.CAT_FACTS.forEach { add(it) }
    }
}
