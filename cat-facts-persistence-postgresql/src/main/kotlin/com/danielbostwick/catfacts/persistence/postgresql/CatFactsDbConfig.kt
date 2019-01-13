package com.danielbostwick.catfacts.persistence.postgresql

import com.fasterxml.jackson.annotation.JsonProperty
import io.dropwizard.Configuration
import io.dropwizard.db.DataSourceFactory

class CatFactsDbConfig : Configuration() {
    @JsonProperty("database")
    var database = DataSourceFactory()

    @JsonProperty("datasource")
    var dataSource: String = "postgresql"

    @JsonProperty("load_fixtures")
    var loadFixtures: Boolean = false
}
