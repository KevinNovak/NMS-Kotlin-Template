package me.kevinnovak.nms_kotlin_template.commands

import org.bukkit.entity.Player

interface Command {
    var name: String
    var aliases: List<String>
    var usage: String
    var description: String
    fun execute(player: Player, args: Array<String>)
}