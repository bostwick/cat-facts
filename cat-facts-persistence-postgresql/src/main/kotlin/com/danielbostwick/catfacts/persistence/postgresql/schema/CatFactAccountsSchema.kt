package com.danielbostwick.catfacts.persistence.postgresql.schema

object CatFactAccountsSchema {
    const val TABLE_NAME = "cat_fact_accounts"

    const val COLUMN_ID = "id"
    const val COLUMN_NAME = "name"
    const val COLUMN_CREATED_AT = "created_at"

    const val QUERY_PARAM_ID = "id"
    const val QUERY_PARAM_NAME = "name"
}
