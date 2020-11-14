package me.kevinnovak.nms_kotlin_template.commands

import org.bukkit.entity.Player

class TestCommand : Command {
    override var name = "test"
    override var aliases = arrayOf("t")

    override fun execute(player: Player, args: Array<String>) {
        player.sendMessage("Test command!")
    }
}