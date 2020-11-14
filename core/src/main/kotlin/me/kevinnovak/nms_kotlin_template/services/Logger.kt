package me.kevinnovak.nms_kotlin_template.services

import org.bukkit.Bukkit
import java.lang.Exception

class Logger {
    companion object {
        fun info(message: String) {
            Bukkit.getLogger().info("[NmsKotlinTutorial] $message")
        }

        fun warn(message: String) {
            Bukkit.getLogger().warning("[NmsKotlinTutorial] $message")
        }

        fun error(message: String, ex: Exception? = null) {
            Bukkit.getLogger().severe("[NmsKotlinTutorial] $message")

            if (ex == null) {
                return
            }

            Bukkit.getLogger().severe(ex.stackTraceToString())
        }
    }
}