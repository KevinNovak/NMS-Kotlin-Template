package me.kevinnovak.nms_kotlin_template.services

import net.md_5.bungee.api.ChatMessageType
import net.md_5.bungee.api.chat.TextComponent
import org.bukkit.entity.Player

class VersionService_v1_20_R1 : VersionService {
    override fun sendActionBar(player: Player, message: String) {
        player.spigot().sendMessage(ChatMessageType.ACTION_BAR, TextComponent(message))
    }
}