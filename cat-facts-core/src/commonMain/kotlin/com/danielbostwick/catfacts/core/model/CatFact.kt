package com.danielbostwick.catfacts.core.model

import com.danielbostwick.catfacts.core.type.UUID

data class CatFact(
    val id: UUID,
    val content: String,
    val authorId: UUID
)