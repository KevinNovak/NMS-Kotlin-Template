package me.kevinnovak.nms_kotlin_template.services

import org.bukkit.entity.Player

interface VersionService {
    fun sendActionBar(player: Player, message: String)
}