package me.kevinnovak.nmskotlintemplate.services

import net.minecraft.server.v1_11_R1.IChatBaseComponent
import net.minecraft.server.v1_11_R1.PacketPlayOutChat
import org.bukkit.craftbukkit.v1_11_R1.entity.CraftPlayer
import org.bukkit.entity.Player

class VersionService_v1_11_R1 : VersionService {
    override fun sendActionBar(player: Player, message: String) {
        val chatComponent = IChatBaseComponent.ChatSerializer.a("{\"text\":\"$message\"}")
        val packet = PacketPlayOutChat(chatComponent, 2.toByte())
        (player as CraftPlayer).handle.playerConnection.sendPacket(packet)
    }
}