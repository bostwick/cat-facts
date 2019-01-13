package com.danielbostwick.catfacts.persistence.postgresql.mapper

import com.danielbostwick.catfacts.core.model.CatFact
import com.danielbostwick.catfacts.core.type.createUuidFromString
import com.danielbostwick.catfacts.persistence.postgresql.schema.CatFactsSchema
import org.skife.jdbi.v2.StatementContext
import org.skife.jdbi.v2.tweak.ResultSetMapper
import java.sql.ResultSet

class CatFactMapper : ResultSetMapper<CatFact> {

    override fun map(index: Int, rs: ResultSet, ctx: StatementContext): CatFact =
        CatFact(
            id = createUuidFromString(rs.getString(CatFactsSchema.COLUMN_ID)),
            content = rs.getString(CatFactsSchema.COLUMN_CONTENT),
            authorId = createUuidFromString(rs.getString(CatFactsSchema.COLUMN_AUTHOR_ID)),
            createdAt = rs.getDate(CatFactsSchema.COLUMN_CREATED_AT)
        )
}