package com.danielbostwick.catfacts.persistence.postgresql

import com.danielbostwick.catfacts.core.Fixtures
import com.danielbostwick.catfacts.core.model.CatFactAccount
import com.danielbostwick.catfacts.core.persistence.CatFactAccountRepository
import com.danielbostwick.catfacts.core.type.UUID
import com.danielbostwick.catfacts.persistence.postgresql.dao.CatFactAccountDao

class PostgresqlCatFactsAccountRepository(private val accountDao: CatFactAccountDao) : CatFactAccountRepository {

    override fun add(account: CatFactAccount) {
        accountDao.create(account.name)
    }

    override fun get(accountId: UUID): CatFactAccount? {
        return accountDao.findById(accountId)
    }

    override fun remove(accountId: UUID) {
        NotImplementedError()
    }

    fun loadFixtures(): CatFactAccount {
        return Fixtures.ACCOUNTS.map { accountDao.create(it.name) }.last()
    }
}
