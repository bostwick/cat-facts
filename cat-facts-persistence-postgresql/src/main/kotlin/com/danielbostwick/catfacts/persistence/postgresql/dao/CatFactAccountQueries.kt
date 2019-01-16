package com.danielbostwick.catfacts.persistence.postgresql.dao

import com.danielbostwick.catfacts.persistence.postgresql.schema.CatFactAccountsSchema

@Suppress("RemoveSingleExpressionStringTemplate")
object CatFactAccountQueries {

    const val CREATE =
        "INSERT INTO ${CatFactAccountsSchema.TABLE_NAME} (" +
            "${CatFactAccountsSchema.COLUMN_ID}," +
            "${CatFactAccountsSchema.COLUMN_NAME}" +
            ") VALUES (" +
            "uuid_generate_v4()," +
            ":${CatFactAccountsSchema.QUERY_PARAM_NAME}" +
            ") RETURNING *"

    const val FIND_BY_ID =
        "SELECT * FROM ${CatFactAccountsSchema.TABLE_NAME} " +
            "WHERE ${CatFactAccountsSchema.COLUMN_ID} = :${CatFactAccountsSchema.QUERY_PARAM_ID}"
}
