package me.kevinnovak.nms_kotlin_template.services

import net.minecraft.server.v1_13_R2.ChatMessageType
import net.minecraft.server.v1_13_R2.IChatBaseComponent
import net.minecraft.server.v1_13_R2.PacketPlayOutChat
import org.bukkit.craftbukkit.v1_13_R2.entity.CraftPlayer
import org.bukkit.entity.Player

class VersionService_v1_13_R2 : VersionService {
    override fun sendActionBar(player: Player, message: String) {
        val chatComponent = IChatBaseComponent.ChatSerializer.a("{\"text\":\"$message\"}")
        val packet = PacketPlayOutChat(chatComponent, ChatMessageType.GAME_INFO)
        (player as CraftPlayer).handle.playerConnection.sendPacket(packet)
    }
}