package me.kevinnovak.nms_kotlin_template.services

import org.bukkit.Bukkit
import java.lang.Exception

const val PLUGIN_NAME = "NmsKotlinTutorial"

class Logger {
    companion object {
        fun info(message: String) {
            Bukkit.getLogger().info("[$PLUGIN_NAME] $message")
        }

        fun warn(message: String) {
            Bukkit.getLogger().warning("[$PLUGIN_NAME] $message")
        }

        fun error(message: String, ex: Exception? = null) {
            Bukkit.getLogger().severe("[$PLUGIN_NAME] $message")

            if (ex == null) {
                return
            }

            Bukkit.getLogger().severe(ex.stackTraceToString())
        }
    }
}