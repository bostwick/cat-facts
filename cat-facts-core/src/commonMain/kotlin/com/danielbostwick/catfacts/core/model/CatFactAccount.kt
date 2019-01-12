package com.danielbostwick.catfacts.core.model

import com.danielbostwick.catfacts.core.type.Date
import com.danielbostwick.catfacts.core.type.UUID

data class CatFactAccount(
    val id: UUID,
    val name: String,
    val createdAt: Date
)
