package me.kevinnovak.nmskotlintemplate.services

import me.kevinnovak.nmskotlintemplate.constants.Constants
import org.bukkit.Bukkit

class Logger {
    companion object {
        fun info(message: String) {
            Bukkit.getLogger().info("[${Constants.PLUGIN_NAME_SHORT}] $message")
        }

        fun warn(message: String) {
            Bukkit.getLogger().warning("[${Constants.PLUGIN_NAME_SHORT}] $message")
        }

        fun error(message: String, ex: Exception? = null) {
            Bukkit.getLogger().severe("[${Constants.PLUGIN_NAME_SHORT}] $message")

            if (ex == null) {
                return
            }

            Bukkit.getLogger().severe(ex.stackTraceToString())
        }
    }
}