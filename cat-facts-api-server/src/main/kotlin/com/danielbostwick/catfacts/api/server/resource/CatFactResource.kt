package com.danielbostwick.catfacts.api.server.resource

import com.danielbostwick.catfacts.core.persistence.CatFactRepository
import com.danielbostwick.catfacts.core.type.UUID
import javax.ws.rs.GET
import javax.ws.rs.Path
import javax.ws.rs.PathParam
import javax.ws.rs.Produces
import javax.ws.rs.core.MediaType
import javax.ws.rs.core.Response

@Path("/catfact/{id}")
@Produces(MediaType.APPLICATION_JSON)
class CatFactResource(private val catFactRepository: CatFactRepository) {

    @GET
    fun fetch(@PathParam("id") catFactId: UUID): Response =
        when (val catFact = catFactRepository.get(catFactId)) {
            null -> Response.status(Response.Status.NOT_FOUND)
            else -> Response.ok(catFact)
        }.build()
}