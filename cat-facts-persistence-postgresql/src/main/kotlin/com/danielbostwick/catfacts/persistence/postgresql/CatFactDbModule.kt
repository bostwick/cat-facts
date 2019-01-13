package com.danielbostwick.catfacts.persistence.postgresql

import com.danielbostwick.catfacts.core.persistence.CatFactAccountRepository
import com.danielbostwick.catfacts.core.persistence.CatFactRepository
import com.danielbostwick.catfacts.persistence.postgresql.dao.CatFactAccountDao
import com.danielbostwick.catfacts.persistence.postgresql.dao.CatFactDao
import org.skife.jdbi.v2.DBI

class CatFactDbModule(jdbi: DBI) {

    val catfactDao: CatFactDao = jdbi.onDemand(CatFactDao::class.java)
    val accountDao: CatFactAccountDao = jdbi.onDemand(CatFactAccountDao::class.java)

    val catFactRepo: CatFactRepository = PostgresqlCatFactsRepository(catfactDao)
    val accountRepo: CatFactAccountRepository = PostgresqlCatFactsAccountRepository(accountDao)
}