package me.kevinnovak.nms_kotlin_template.commands

import org.bukkit.entity.Player

interface Command {
    var name: String
    var aliases: Array<String>
    fun execute(player: Player, args: Array<String>)
}