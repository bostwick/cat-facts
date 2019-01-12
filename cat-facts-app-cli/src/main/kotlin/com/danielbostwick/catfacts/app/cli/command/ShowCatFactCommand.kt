package com.danielbostwick.catfacts.app.cli.command

import com.danielbostwick.catfacts.api.client.CatFactsApi
import com.danielbostwick.catfacts.app.cli.CatFactServices
import com.danielbostwick.catfacts.app.cli.CatFactsCliCommand
import com.danielbostwick.catfacts.app.cli.prettyPrintCatFact
import com.danielbostwick.catfacts.core.type.UUID
import com.danielbostwick.catfacts.core.type.createUuidFromString

class ShowCatFactCommand(private val catfactId: UUID) : CatFactsCliCommand() {

    companion object {
        const val NAME = "show"

        fun parse(vararg args: String): ShowCatFactCommand {
            if (args.isEmpty()) throw InvalidCommandError("Missing cat fact id")
            if (args.size > 1) throw InvalidCommandError("Unknown extra arguments $args")

            try {
                val catfactId = createUuidFromString(args[0])
                return ShowCatFactCommand(catfactId)
            } catch (e: IllegalArgumentException) {
                throw InvalidCommandError(e.message ?: "")
            }
        }
    }

    private val catFactsApi: CatFactsApi = CatFactServices.catFactsApi

    override fun invoke() =
        catFactsApi.fetchCatfact(catfactId)
            .blockingGet()
            .run(::prettyPrintCatFact)
            .run(::println)
}
