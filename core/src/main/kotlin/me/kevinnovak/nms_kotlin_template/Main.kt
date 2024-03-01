package me.kevinnovak.nms_kotlin_template

import me.kevinnovak.nms_kotlin_template.commands.HelpCommand
import me.kevinnovak.nms_kotlin_template.commands.TestCommand
import me.kevinnovak.nms_kotlin_template.events.CommandHandler
import me.kevinnovak.nms_kotlin_template.models.DataFile
import me.kevinnovak.nms_kotlin_template.services.Logger
import me.kevinnovak.nms_kotlin_template.services.VersionService
import org.bstats.bukkit.Metrics
import org.bukkit.command.Command
import org.bukkit.command.CommandSender
import org.bukkit.event.Listener
import org.bukkit.plugin.java.JavaPlugin

const val PREFIX = "test"
const val METRICS_PLUGIN_ID = 1

class Main : JavaPlugin(), Listener {
    private lateinit var commandHandler: CommandHandler
    private lateinit var versionService: VersionService

    private var ready: Boolean = false

    override fun onEnable() {
        Logger.info("Starting plugin...")

        Logger.info("Loading files...")
        var config = DataFile(this, "config.yml", "config.yml")
        config.load()

        // Determine version
        var version: String?
        if (config.getBoolean("force-nms-version.enabled")!!) {
            version = config.getString("force-nms-version.version")
        } else {
            Logger.info("Determining NMS version...")
            try {
                version = this.server.javaClass.`package`.name.split(".")[3]
            } catch (ex: Exception) {
                Logger.error("Could not determine NMS version.", ex)
                this.disable()
                return
            }
        }

        try {
            this.versionService = Class.forName("${VersionService::class.qualifiedName}_$version").getDeclaredConstructor().newInstance() as VersionService
            Logger.info("Using NMS version \"$version\".")
        } catch (ex: Exception) {
            Logger.warn("Could not find an implementation for NMS version \"$version\".")
            this.disable()
            return
        }

        // Dependency injection
        var testCommand = TestCommand(this.versionService)
        var commands = listOf(testCommand)
        var helpCommand = HelpCommand(commands)
        commandHandler = CommandHandler(PREFIX, helpCommand, listOf(testCommand))

        if (config.getBoolean("metrics")!!) {
            Logger.info("Enabling metrics...")
            Metrics(this, METRICS_PLUGIN_ID)
        }

        Logger.info("Plugin started.")
        this.ready = true
    }

    override fun onDisable() {
        Logger.info("Plugin stopped.")
    }

    override fun onCommand(sender: CommandSender, cmd: Command, commandLabel: String, args: Array<String>): Boolean {
        if (!this.ready) {
            return true
        }

        return this.commandHandler.process(sender, cmd, args)
    }

    private fun disable() {
        this.server.pluginManager.disablePlugin(this)
    }
}