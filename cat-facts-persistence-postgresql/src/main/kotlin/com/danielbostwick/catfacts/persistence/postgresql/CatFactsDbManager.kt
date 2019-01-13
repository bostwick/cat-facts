package com.danielbostwick.catfacts.persistence.postgresql

import io.dropwizard.Application
import io.dropwizard.migrations.MigrationsBundle
import io.dropwizard.setup.Bootstrap
import io.dropwizard.setup.Environment

class CatFactsDbManager : Application<CatFactsDbConfig>() {

    companion object {

        @JvmStatic
        fun main(args: Array<String>) {
            CatFactsDbManager().run(*args)
        }
    }

    override fun initialize(bootstrap: Bootstrap<CatFactsDbConfig>) {
        bootstrap.addBundle(migrationsBundle)
    }

    override fun run(configuration: CatFactsDbConfig, environment: Environment) = Unit

    private val migrationsBundle: MigrationsBundle<CatFactsDbConfig> = object : MigrationsBundle<CatFactsDbConfig>() {
        override fun getDataSourceFactory(config: CatFactsDbConfig) = config.database
    }
}
