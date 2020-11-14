package me.kevinnovak.nms_kotlin_template.commands

import org.bukkit.entity.Player

class HelpCommand : Command {
    override var name = "help"
    override var aliases = arrayOf("?")

    override fun execute(player: Player, args: Array<String>) {
        player.sendMessage("Help command!")
    }
}