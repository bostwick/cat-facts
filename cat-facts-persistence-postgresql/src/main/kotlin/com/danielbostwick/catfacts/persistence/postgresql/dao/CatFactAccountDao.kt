package com.danielbostwick.catfacts.persistence.postgresql.dao

import com.danielbostwick.catfacts.core.model.CatFactAccount
import com.danielbostwick.catfacts.core.type.UUID
import com.danielbostwick.catfacts.persistence.postgresql.mapper.CatFactAccountMapper
import com.danielbostwick.catfacts.persistence.postgresql.schema.CatFactAccountsSchema
import org.skife.jdbi.v2.sqlobject.Bind
import org.skife.jdbi.v2.sqlobject.SqlQuery
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapper

@RegisterMapper(CatFactAccountMapper::class)
interface CatFactAccountDao {

    @SqlQuery(CatFactAccountQueries.CREATE)
    fun create(@Bind(CatFactAccountsSchema.QUERY_PARAM_NAME) name: String): CatFactAccount

    @SqlQuery(CatFactAccountQueries.FIND_BY_ID)
    fun findById(@Bind(CatFactAccountsSchema.QUERY_PARAM_ID) accountId: UUID): CatFactAccount
}