package com.danielbostwick.catfacts.core.persistence

import com.danielbostwick.catfacts.core.model.CatFactAccount
import com.danielbostwick.catfacts.core.type.UUID

interface CatFactAccountRepository {

    fun add(account: CatFactAccount)

    fun remove(accountId: UUID)

    fun get(accountId: UUID): CatFactAccount?
}
