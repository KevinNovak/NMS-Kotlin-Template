package me.kevinnovak.nms_kotlin_template.commands

import me.kevinnovak.nms_kotlin_template.services.VersionService
import org.bukkit.entity.Player

class TestCommand(private var versionService: VersionService) : Command {
    override var name = "test"
    override var aliases = arrayOf("t")

    override fun execute(player: Player, args: Array<String>) {
        this.versionService.sendActionBar(player, "This is a test!")
        player.sendMessage("Ran test command!")
    }
}