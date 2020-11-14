package me.kevinnovak.nms_kotlin_template

import me.kevinnovak.nms_kotlin_template.commands.*
import me.kevinnovak.nms_kotlin_template.events.*
import me.kevinnovak.nms_kotlin_template.services.*
import org.bukkit.command.Command
import org.bukkit.command.CommandSender
import org.bukkit.event.Listener
import org.bukkit.plugin.java.JavaPlugin

class Main : JavaPlugin(), Listener {
    private lateinit var commandHandler: CommandHandler
    private lateinit var versionService: VersionService

    private var ready: Boolean = false

    override fun onEnable() {
        Logger.info("Starting plugin...")

        // Determine version
        Logger.info("Determining NMS version...")
        var version: String?
        try {
            version = this.server.javaClass.`package`.name.split(".")[3]
        } catch (ex: Exception) {
            Logger.error("Could not determine NMS version.", ex)
            this.disable()
            return
        }

        try {
            this.versionService = Class.forName("${VersionService::class.qualifiedName}_$version").newInstance() as VersionService
            Logger.info("Using NMS version \"$version\".")
        } catch (ex: Exception) {
            Logger.warn("Could not find an implementation for NMS version \"$version\".")
            this.disable()
            return
        }

        Logger.info("Loading config files...")
        // TODO: Why does this return Unit?
        // TODO: Use config
        val config = Config(this, "config.yml", "config.yml").load()

        // Dependency injection
        var helpCommand = HelpCommand()
        var testCommand = TestCommand(this.versionService)
        commandHandler = CommandHandler("test", helpCommand, arrayOf(testCommand))

        this.ready = true

        Logger.info("Plugin started.")
    }

    override fun onDisable() {
        Logger.info("Plugin stopped.")
    }

    override fun onCommand(sender: CommandSender, cmd: Command, commandLabel: String, args: Array<String>): Boolean {
        if (!this.ready) {
            return true
        }

        return this.commandHandler.process(sender, cmd, commandLabel, args)
    }

    private fun disable() {
        this.server.pluginManager.disablePlugin(this)
    }
}