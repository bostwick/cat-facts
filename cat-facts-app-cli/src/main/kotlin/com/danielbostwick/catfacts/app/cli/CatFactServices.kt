package com.danielbostwick.catfacts.app.cli

import com.danielbostwick.catfacts.api.client.CatFactsApi

object CatFactServices {

    val catFactsApi: CatFactsApi =
        CatFactsApi.create(apiRoot = CatFactsApi.API_ROOT_LOCALHOST)
}