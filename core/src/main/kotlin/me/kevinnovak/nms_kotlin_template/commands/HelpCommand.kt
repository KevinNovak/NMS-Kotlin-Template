package me.kevinnovak.nms_kotlin_template.commands

import me.kevinnovak.nms_kotlin_template.services.MessageService
import org.bukkit.entity.Player

class HelpCommand(private var commands: List<Command>) : Command {
    override var name = "help"
    override var aliases = listOf("?")
    override var usage: String = "/test help"
    override var description: String = "Shows plugin help."

    override fun execute(player: Player, args: Array<String>) {
        var lines = mutableListOf("&e-------- &6NMS Kotlin Template &e- &6Commands &e--------")
        for (command in this.commands) {
            if (player.hasPermission("nmskotlintemplate.commands.${command.name}")) {
                lines.add("&b${command.usage} &7- ${command.description}")
            }
        }
        var msg = lines.joinToString("\n")
        MessageService.send(player, msg)
    }
}