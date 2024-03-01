package me.kevinnovak.nmskotlintemplate.services

import me.kevinnovak.nmskotlintemplate.utils.StringUtils
import org.bukkit.entity.Player

class MessageService {
    companion object {
        fun send(player: Player, msg: String) {
            val coloredMsg = StringUtils.color(msg)
            player.sendMessage(coloredMsg)
        }
    }
}