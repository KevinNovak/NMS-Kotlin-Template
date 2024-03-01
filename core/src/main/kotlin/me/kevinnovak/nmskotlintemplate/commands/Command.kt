package me.kevinnovak.nmskotlintemplate.commands

import org.bukkit.entity.Player

interface Command {
    var name: String
    var usage: String
    var description: String
    fun execute(player: Player, args: Array<String>)
}