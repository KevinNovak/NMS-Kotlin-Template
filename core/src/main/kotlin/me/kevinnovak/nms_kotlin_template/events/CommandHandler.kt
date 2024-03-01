package me.kevinnovak.nms_kotlin_template.events

import me.kevinnovak.nms_kotlin_template.commands.Command
import org.bukkit.command.Command as BukkitCommand
import org.bukkit.command.CommandSender
import org.bukkit.entity.Player

class CommandHandler(private var prefix: String, private var helpCommand: Command, private var commands: List<Command>) {

    fun process(sender: CommandSender, cmd: BukkitCommand, args: Array<String>): Boolean {
        if (sender !is Player) {
            return true
        }

        if (cmd.name.toLowerCase() != this.prefix) {
            return true
        }

        if (args.isEmpty()) {
            this.helpCommand.execute(sender, args)
            return true
        }

        var userCommand = args[0]
        var command = this.findCommand(userCommand)

        if (command == null) {
            this.helpCommand.execute(sender, args)
            return true
        }

        // TODO: Logs
        command.execute(sender, args)
        return true
    }

    private fun findCommand(input: String): Command? {
        var commandName = input.toLowerCase()
        for (command in this.commands) {
            if (command.name == commandName) {
                return command
            }

            if (command.aliases.contains(commandName)) {
                return command
            }
        }
        return null
    }
}