package me.kevinnovak.nms_kotlin_template.services

import org.bukkit.Bukkit

const val PLUGIN_NAME = "NmsKotlinTemplate"

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