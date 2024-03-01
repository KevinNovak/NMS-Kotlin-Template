package me.kevinnovak.nmskotlintemplate.commands

import me.kevinnovak.nmskotlintemplate.constants.Constants
import me.kevinnovak.nmskotlintemplate.services.MessageService
import org.bukkit.entity.Player

class HelpCommand(private var commands: List<Command>) : Command {
    override var name = "help"
    override var usage: String = "/${Constants.COMMAND_PREFIX}"
    override var description: String = "Shows plugin help."

    override fun execute(player: Player, args: Array<String>) {
        val lines = mutableListOf("&e-------- &6${Constants.PLUGIN_NAME_LONG} &e- &6Commands &e--------")
        lines.add(formatLine(this))
        for (command in this.commands) {
            if (player.hasPermission("${Constants.PERMISSIONS_PREFIX}.commands.${command.name}")) {
                lines.add(formatLine(command))
            }
        }
        val msg = lines.joinToString("\n")
        MessageService.send(player, msg)
    }

    private fun formatLine(command: Command): String {
        return "&b${command.usage} &7- ${command.description}"
    }
}