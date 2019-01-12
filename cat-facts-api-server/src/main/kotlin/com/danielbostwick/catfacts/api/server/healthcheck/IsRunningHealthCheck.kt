package com.danielbostwick.catfacts.api.server.healthcheck

import com.codahale.metrics.health.HealthCheck

/**
 * A dropwizard health check that always returns "Healthy".
 */
class IsRunningHealthCheck : HealthCheck() {

    companion object {
        const val NAME = "is_running"
    }

    override fun check(): Result = Result.healthy()
}
