package com.danielbostwick.catfacts.api.server.resource

import com.danielbostwick.catfacts.core.persistence.CatFactAccountRepository
import com.danielbostwick.catfacts.core.type.UUID
import javax.ws.rs.GET
import javax.ws.rs.Path
import javax.ws.rs.PathParam
import javax.ws.rs.Produces
import javax.ws.rs.core.MediaType
import javax.ws.rs.core.Response

@Path("/account/{id}")
@Produces(MediaType.APPLICATION_JSON)
class CatFactsAccountResource(private val accountRepository: CatFactAccountRepository) {

    @GET
    fun fetch(@PathParam("id") accountId: UUID): Response =
        when (val account = accountRepository.get(accountId)) {
            null -> Response.status(Response.Status.NOT_FOUND)
            else -> Response.ok(account)
        }.build()
}