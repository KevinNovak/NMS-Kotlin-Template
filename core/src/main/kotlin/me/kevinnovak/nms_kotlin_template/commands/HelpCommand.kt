package me.kevinnovak.nms_kotlin_template.commands

import me.kevinnovak.nms_kotlin_template.services.MessageService
import org.bukkit.entity.Player

class HelpCommand(private var commands: List<Command>) : Command {
    override var name = "help"
    override var usage: String = "/test"
    override var description: String = "Shows plugin help."

    override fun execute(player: Player, args: Array<String>) {
        val lines = mutableListOf("&e-------- &6NMS Kotlin Template &e- &6Commands &e--------")
        lines.add(formatLine(this))
        for (command in this.commands) {
            if (player.hasPermission("nmskotlintemplate.commands.${command.name}")) {
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