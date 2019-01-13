package com.danielbostwick.catfacts.persistence.postgresql

import com.danielbostwick.catfacts.core.Fixtures
import com.danielbostwick.catfacts.core.model.CatFact
import com.danielbostwick.catfacts.core.model.CatFactAccount
import com.danielbostwick.catfacts.core.persistence.CatFactRepository
import com.danielbostwick.catfacts.core.type.UUID
import com.danielbostwick.catfacts.persistence.postgresql.dao.CatFactDao

class PostgresqlCatFactsRepository(private val catFactDao: CatFactDao) : CatFactRepository {

    override fun add(fact: CatFact) {
        catFactDao.create(fact.content, fact.authorId)
    }

    override fun get(factId: UUID): CatFact? {
        return catFactDao.findById(factId)
    }

    override fun getAll(): List<CatFact> {
        return catFactDao.findAll()
    }

    override fun remove(factId: UUID) {
        NotImplementedError()
    }

    fun loadFixtures(account: CatFactAccount) {
        Fixtures.CAT_FACTS.forEach { catFactDao.create(it.content, account.id) }
    }
}
