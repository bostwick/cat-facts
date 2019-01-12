package com.danielbostwick.catfacts.app.cli

import com.danielbostwick.catfacts.app.cli.command.HelpCommand
import com.danielbostwick.catfacts.app.cli.command.ListCatFactsCommand
import com.danielbostwick.catfacts.app.cli.command.ShowCatFactCommand

abstract class CatFactsCliCommand {

    companion object {

        fun parse(vararg args: String): CatFactsCliCommand =
            try {
                parseFromArgs(*args)
            } catch (e: InvalidCommandError) {
                HelpCommand(e.message ?: "Unknown error")
            }

        private fun parseFromArgs(vararg args: String): CatFactsCliCommand {
            if (args.isEmpty()) throw InvalidCommandError("No command specified")

            val cmdName = args.first()

            return when (cmdName.toLowerCase()) {
                HelpCommand.NAME -> HelpCommand()
                ListCatFactsCommand.NAME -> ListCatFactsCommand()
                ShowCatFactCommand.NAME -> ShowCatFactCommand.parse(*args.sliceArray(1 until args.size))
                else -> throw InvalidCommandError("Unknown command $cmdName")
            }
        }
    }

    abstract fun invoke()

    class InvalidCommandError(msg: String) : RuntimeException(msg)
}
