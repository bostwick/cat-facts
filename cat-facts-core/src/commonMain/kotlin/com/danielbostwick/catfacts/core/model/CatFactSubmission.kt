package com.danielbostwick.catfacts.core

import com.danielbostwick.catfacts.core.type.Date
import com.danielbostwick.catfacts.core.type.UUID

data class CatFactSubmission(
    val id: UUID,
    val content: String,
    val authorId: UUID,
    val submittedAt: Date
)