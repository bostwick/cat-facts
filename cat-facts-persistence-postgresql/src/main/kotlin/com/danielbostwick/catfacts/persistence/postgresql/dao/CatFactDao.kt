package com.danielbostwick.catfacts.persistence.postgresql.dao

import com.danielbostwick.catfacts.core.model.CatFact
import com.danielbostwick.catfacts.core.type.UUID
import com.danielbostwick.catfacts.persistence.postgresql.mapper.CatFactMapper
import com.danielbostwick.catfacts.persistence.postgresql.schema.CatFactsSchema
import org.skife.jdbi.v2.sqlobject.Bind
import org.skife.jdbi.v2.sqlobject.SqlQuery
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapper

@RegisterMapper(CatFactMapper::class)
interface CatFactDao {

    @SqlQuery(CatFactQueries.CREATE)
    fun create(
        @Bind(CatFactsSchema.QUERY_PARAM_CONTENT) content: String,
        @Bind(CatFactsSchema.QUERY_PARAM_AUTHOR_ID) authorId: UUID
    ): CatFact

    @SqlQuery(CatFactQueries.FIND_ALL)
    fun findAll(): List<CatFact>

    @SqlQuery(CatFactQueries.FIND_BY_ID)
    fun findById(@Bind(CatFactsSchema.QUERY_PARAM_ID) catfactId: UUID): CatFact

}