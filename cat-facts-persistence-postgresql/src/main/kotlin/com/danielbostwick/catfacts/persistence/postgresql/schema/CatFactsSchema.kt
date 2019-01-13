package com.danielbostwick.catfacts.persistence.postgresql.schema

object CatFactsSchema {
    const val TABLE_NAME = "cat_facts"

    const val COLUMN_ID = "id"
    const val COLUMN_CONTENT = "content"
    const val COLUMN_AUTHOR_ID = "author_id"
    const val COLUMN_CREATED_AT = "created_at"

    const val QUERY_PARAM_ID = "id"
    const val QUERY_PARAM_CONTENT = "content"
    const val QUERY_PARAM_AUTHOR_ID = "author_id"
}
