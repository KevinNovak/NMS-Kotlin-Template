package me.kevinnovak.nmskotlintemplate.services

import net.minecraft.server.v1_16_R2.ChatMessageType
import net.minecraft.server.v1_16_R2.IChatBaseComponent
import net.minecraft.server.v1_16_R2.PacketPlayOutChat
import org.bukkit.craftbukkit.v1_16_R2.entity.CraftPlayer
import org.bukkit.entity.Player

class VersionService_v1_16_R2 : VersionService {
    override fun sendActionBar(player: Player, message: String) {
        val chatComponent: IChatBaseComponent? = IChatBaseComponent.ChatSerializer.a("{\"text\":\"$message\"}")
        val packet = PacketPlayOutChat(chatComponent, ChatMessageType.GAME_INFO, player.uniqueId)
        (player as CraftPlayer).handle.playerConnection.sendPacket(packet)
    }
}