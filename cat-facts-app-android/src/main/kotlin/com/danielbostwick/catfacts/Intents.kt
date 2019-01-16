package com.danielbostwick.catfacts

import android.content.Context
import android.content.Intent
import com.danielbostwick.catfacts.core.type.UUID

object Intents {

    object ShowCatFact {
        private const val EXTRA_CATFACT_ID = "catFactId"

        fun create(context: Context, catFactId: UUID) =
            Intent(context, ShowCatFactActivity::class.java).apply {
                putExtra(EXTRA_CATFACT_ID, catFactId)
            }

        interface Arguments {
            fun getIntent(): Intent

            val argCatFactId: UUID
                get() = getIntent().extras?.getSerializable(EXTRA_CATFACT_ID) as UUID
        }
    }
}
