package com.danielbostwick.catfacts.persistence.postgresql.dao

import com.danielbostwick.catfacts.persistence.postgresql.schema.CatFactsSchema

@Suppress("RemoveSingleExpressionStringTemplate")
object CatFactQueries {

    const val CREATE =
        "INSERT INTO ${CatFactsSchema.TABLE_NAME} (" +
            "${CatFactsSchema.COLUMN_ID}," +
            "${CatFactsSchema.COLUMN_CONTENT}," +
            "${CatFactsSchema.COLUMN_AUTHOR_ID}" +
            ") VALUES (" +
            "uuid_generate_v4()," +
            ":${CatFactsSchema.QUERY_PARAM_CONTENT}," +
            ":${CatFactsSchema.QUERY_PARAM_AUTHOR_ID}" +
            ") RETURNING *"

    const val FIND_ALL =
        "SELECT * FROM ${CatFactsSchema.TABLE_NAME}"

    const val FIND_BY_ID =
        "SELECT * FROM ${CatFactsSchema.TABLE_NAME}" +
            "WHERE ${CatFactsSchema.COLUMN_ID} = :${CatFactsSchema.QUERY_PARAM_ID}"
}