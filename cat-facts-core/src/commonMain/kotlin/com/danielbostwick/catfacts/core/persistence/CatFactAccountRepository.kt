package com.danielbostwick.catfacts.core

import com.danielbostwick.catfacts.core.type.UUID

interface CatFactAccountRepository {

    fun add(account: CatFactAccount)

    fun remove(accountId: UUID)

    fun get(accountId: UUID): CatFactAccount?
}
