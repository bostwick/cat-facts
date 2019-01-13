package com.danielbostwick.catfacts.persistence.postgresql.mapper

import com.danielbostwick.catfacts.core.model.CatFactAccount
import com.danielbostwick.catfacts.core.type.createUuidFromString
import com.danielbostwick.catfacts.persistence.postgresql.schema.CatFactAccountsSchema
import org.skife.jdbi.v2.StatementContext
import org.skife.jdbi.v2.tweak.ResultSetMapper
import java.sql.ResultSet

class CatFactAccountMapper : ResultSetMapper<CatFactAccount> {

    override fun map(index: Int, rs: ResultSet, ctx: StatementContext): CatFactAccount =
        CatFactAccount(
            id = createUuidFromString(rs.getString(CatFactAccountsSchema.COLUMN_ID)),
            name = rs.getString(CatFactAccountsSchema.COLUMN_NAME),
            createdAt = rs.getDate(CatFactAccountsSchema.COLUMN_CREATED_AT)
        )
}
