package com.danielbostwick.catfacts.app.cli

import com.danielbostwick.catfacts.core.model.CatFact
import com.danielbostwick.catfacts.core.type.Date
import java.text.SimpleDateFormat
import java.util.*

private const val DATE_FORMAT = "MMMMMM dd, yyyy HH:mm"

fun prettyPrintCatFact(catFact: CatFact): String =
    catFact.content + "\n" +
            prettyPrintDate(catFact.createdAt) + " · " + catFact.id

fun prettyPrintDate(date: Date): String =
    SimpleDateFormat(DATE_FORMAT, Locale.US).format(date)
