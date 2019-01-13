package com.danielbostwick.catfacts.api.server

import com.fasterxml.jackson.annotation.JsonProperty
import io.dropwizard.Configuration
import io.dropwizard.db.DataSourceFactory

class CatFactsApiServerConfig : Configuration() {

    companion object {
        const val DATASOURCE_IN_MEMORY = "inmemory"
        const val DATASOURCE_DATABASE_PSQL = "postgresql"
    }

    @JsonProperty("datasource")
    var dataSource: String = DATASOURCE_IN_MEMORY

    @JsonProperty("database")
    var database = DataSourceFactory()

    @JsonProperty("load_fixtures")
    var loadFixtures: Boolean = false
}