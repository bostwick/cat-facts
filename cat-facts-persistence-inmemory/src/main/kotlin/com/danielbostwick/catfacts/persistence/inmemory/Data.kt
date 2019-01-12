package com.danielbostwick.catfacts.persistence.inmemory

import com.danielbostwick.catfacts.core.model.CatFact
import com.danielbostwick.catfacts.core.model.CatFactAccount

object Data {

    val accounts: MutableSet<CatFactAccount> = mutableSetOf()

    val facts: MutableSet<CatFact> = mutableSetOf()
}