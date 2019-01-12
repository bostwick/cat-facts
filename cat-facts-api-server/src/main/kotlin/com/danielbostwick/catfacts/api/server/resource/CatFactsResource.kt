package com.danielbostwick.catfacts.api.server.resource

import com.danielbostwick.catfacts.core.persistence.CatFactRepository
import javax.ws.rs.GET
import javax.ws.rs.Path
import javax.ws.rs.Produces
import javax.ws.rs.core.MediaType
import javax.ws.rs.core.Response

@Path("/catfacts")
@Produces(MediaType.APPLICATION_JSON)
class CatFactsResource(private val catfactRepository: CatFactRepository) {

    @GET
    fun fetchAll(): Response =
        Response
            .ok(catfactRepository.getAll())
            .build()
}
