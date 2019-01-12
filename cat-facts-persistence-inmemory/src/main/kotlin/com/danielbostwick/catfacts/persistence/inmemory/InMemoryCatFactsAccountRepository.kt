package com.danielbostwick.catfacts.persistence.inmemory

import com.danielbostwick.catfacts.core.Fixtures
import com.danielbostwick.catfacts.core.model.CatFactAccount
import com.danielbostwick.catfacts.core.persistence.CatFactAccountRepository
import com.danielbostwick.catfacts.core.type.UUID

class InMemoryCatFactAccountRepository : CatFactAccountRepository {

    override fun add(account: CatFactAccount) {
        Data.accounts.add(account)
    }

    override fun get(accountId: UUID): CatFactAccount? {
        return Data.accounts.find { it.id == accountId }
    }

    override fun remove(accountId: UUID) {
        Data.accounts.removeIf { it.id == accountId }
    }

    fun loadFixtures() {
        Fixtures.ACCOUNTS.forEach { add(it) }
    }
}
