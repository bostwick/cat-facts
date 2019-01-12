package com.danielbostwick.catfacts.app.cli.command

import com.danielbostwick.catfacts.app.cli.CatFactsCliCommand

class HelpCommand(private val errorMsg: String = "") : CatFactsCliCommand() {

    companion object {
        const val NAME = "help"
    }

    private val errorMsgContent: String
        get() = if (errorMsg.isNotEmpty()) errorMsg + "\n\n" else ""

    override fun invoke() = println(
        errorMsgContent +
                "usage: cat-facts <command> [<args>]\n\n" +
                "    help	Show this help message\n" +
                "    list List all the cat facts\n" +
                "    show <cat fact id> Show a specific cat fact"
    )
}