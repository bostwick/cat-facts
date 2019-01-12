package com.danielbostwick.catfacts.app.cli

class CatFactsCliApp {

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            CatFactsCliApp().run(*args)
        }
    }

    fun run(vararg args: String) =
        CatFactsCliCommand
            .parse(*args)
            .invoke()
}
