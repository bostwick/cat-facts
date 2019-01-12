package com.danielbostwick.catfacts.app.cli.command

import com.danielbostwick.catfacts.api.client.CatFactsApi
import com.danielbostwick.catfacts.app.cli.CatFactServices
import com.danielbostwick.catfacts.app.cli.CatFactsCliCommand
import com.danielbostwick.catfacts.app.cli.prettyPrintCatFact

class ListCatFactsCommand : CatFactsCliCommand() {

    companion object {
        const val NAME = "list"

        private const val CATFACT_SEPARATOR = "\n--------------------\n"
    }

    private val catFactsApi: CatFactsApi = CatFactServices.catFactsApi

    @Suppress("SimplifiableCallChain")
    override fun invoke() =
        catFactsApi.fetchAllCatFacts()
            .blockingGet()
            .map(::prettyPrintCatFact)
            .joinToString(CATFACT_SEPARATOR)
            .run(::println)
}