package me.kevinnovak.nmskotlintemplate.services

import org.bukkit.entity.Player

interface VersionService {
    fun sendActionBar(player: Player, message: String)
}