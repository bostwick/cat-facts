package com.danielbostwick.catfacts.core.type

actual typealias UUID = java.util.UUID

actual fun createUuidFromString(str: String): UUID =
    java.util.UUID.fromString(str)
