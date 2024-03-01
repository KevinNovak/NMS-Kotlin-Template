package me.kevinnovak.nmskotlintemplate.commands

import me.kevinnovak.nmskotlintemplate.constants.Constants
import me.kevinnovak.nmskotlintemplate.services.VersionService
import org.bukkit.entity.Player

class TestCommand(private var versionService: VersionService) : Command {
    override var name = "test"
    override var usage: String = "/${Constants.COMMAND_PREFIX} $name"
    override var description: String = "Runs the test command."

    override fun execute(player: Player, args: Array<String>) {
        this.versionService.sendActionBar(player, "This is a test!")
        player.sendMessage("Ran test command!")
    }
}