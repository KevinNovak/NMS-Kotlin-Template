package me.kevinnovak.nms_kotlin_template.utils

import org.bukkit.ChatColor

class StringUtils {
    companion object {
        fun color(input: String): String {
            return ChatColor.translateAlternateColorCodes('&', input)
        }
    }
}