package com.danielbostwick.catfacts.core.type

actual typealias Date = java.util.Date

actual fun createDateNow(): Date = java.util.Date()
