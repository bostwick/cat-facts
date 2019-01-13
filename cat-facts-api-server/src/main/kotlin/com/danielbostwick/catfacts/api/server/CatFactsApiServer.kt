package com.danielbostwick.catfacts.api.server

import com.danielbostwick.catfacts.api.server.CatFactsApiServerConfig.Companion.DATASOURCE_DATABASE_PSQL
import com.danielbostwick.catfacts.api.server.CatFactsApiServerConfig.Companion.DATASOURCE_IN_MEMORY
import com.danielbostwick.catfacts.api.server.healthcheck.IsRunningHealthCheck
import com.danielbostwick.catfacts.api.server.resource.CatFactResource
import com.danielbostwick.catfacts.api.server.resource.CatFactsAccountResource
import com.danielbostwick.catfacts.api.server.resource.CatFactsResource
import com.danielbostwick.catfacts.core.persistence.CatFactAccountRepository
import com.danielbostwick.catfacts.core.persistence.CatFactRepository
import com.danielbostwick.catfacts.persistence.inmemory.InMemoryCatFactAccountRepository
import com.danielbostwick.catfacts.persistence.inmemory.InMemoryCatFactRepository
import com.danielbostwick.catfacts.persistence.postgresql.CatFactDbModule
import com.danielbostwick.catfacts.persistence.postgresql.PostgresqlCatFactsAccountRepository
import com.danielbostwick.catfacts.persistence.postgresql.PostgresqlCatFactsRepository
import com.fasterxml.jackson.databind.SerializationFeature
import com.fasterxml.jackson.module.kotlin.KotlinModule
import io.dropwizard.Application
import io.dropwizard.jdbi.DBIFactory
import io.dropwizard.setup.Bootstrap
import io.dropwizard.setup.Environment

@Suppress("unused")
class CatFactsApiServer : Application<CatFactsApiServerConfig>() {

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            CatFactsApiServer().run(*args)
        }
    }

    private lateinit var catfactRepository: CatFactRepository
    private lateinit var accountRepository: CatFactAccountRepository

    override fun initialize(bootstrap: Bootstrap<CatFactsApiServerConfig>) {
    }

    override fun run(configuration: CatFactsApiServerConfig, environment: Environment) {
        initializeRepositories(configuration, environment)

        environment.apply {
            objectMapper.apply {
                registerModule(KotlinModule())

                configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false)
            }

            healthChecks().apply {
                register(IsRunningHealthCheck.NAME, IsRunningHealthCheck())
            }

            jersey().apply {
                register(CatFactResource(catfactRepository))
                register(CatFactsResource(catfactRepository))
                register(CatFactsAccountResource(accountRepository))
            }
        }
    }

    private fun initializeRepositories(configuration: CatFactsApiServerConfig, environment: Environment): Unit =
        when (configuration.dataSource) {
            DATASOURCE_IN_MEMORY -> {
                accountRepository = InMemoryCatFactAccountRepository()
                catfactRepository = InMemoryCatFactRepository()

                if (configuration.loadFixtures) {
                    (accountRepository as InMemoryCatFactAccountRepository).loadFixtures()
                    (catfactRepository as InMemoryCatFactRepository).loadFixtures()
                } else Unit
            }

            DATASOURCE_DATABASE_PSQL -> {
                val dbiFactory = DBIFactory()
                val jdbi = dbiFactory.build(environment, configuration.database, configuration.dataSource)
                val jdbiModule = CatFactDbModule(jdbi)

                accountRepository = jdbiModule.accountRepo
                catfactRepository = jdbiModule.catFactRepo

                if (configuration.loadFixtures) {
                    val acct = (accountRepository as PostgresqlCatFactsAccountRepository).loadFixtures()
                    (catfactRepository as PostgresqlCatFactsRepository).loadFixtures(acct)
                } else Unit
            }
            else -> throw IllegalArgumentException("Unknown datasource ${configuration.dataSource}")
        }
}