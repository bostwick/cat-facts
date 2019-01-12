package com.danielbostwick.catfacts.api.server

import com.danielbostwick.catfacts.api.server.healthcheck.IsRunningHealthCheck
import com.danielbostwick.catfacts.api.server.resource.CatFactResource
import com.danielbostwick.catfacts.api.server.resource.CatFactsAccountResource
import com.danielbostwick.catfacts.api.server.resource.CatFactsResource
import com.danielbostwick.catfacts.core.persistence.CatFactAccountRepository
import com.danielbostwick.catfacts.core.persistence.CatFactRepository
import com.danielbostwick.catfacts.persistence.inmemory.InMemoryCatFactAccountRepository
import com.danielbostwick.catfacts.persistence.inmemory.InMemoryCatFactRepository
import com.fasterxml.jackson.databind.SerializationFeature
import com.fasterxml.jackson.module.kotlin.KotlinModule
import io.dropwizard.Application
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

    lateinit var catfactRepository: CatFactRepository
    lateinit var accountRepository: CatFactAccountRepository

    override fun initialize(bootstrap: Bootstrap<CatFactsApiServerConfig>) {
        accountRepository = InMemoryCatFactAccountRepository()
        catfactRepository = InMemoryCatFactRepository()

        (accountRepository as InMemoryCatFactAccountRepository).loadFixtures()
        (catfactRepository as InMemoryCatFactRepository).loadFixtures()
    }

    override fun run(configuration: CatFactsApiServerConfig, environment: Environment) {
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
}