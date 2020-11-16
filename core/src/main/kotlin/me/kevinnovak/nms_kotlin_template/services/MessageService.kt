package me.kevinnovak.nms_kotlin_template.services

import me.kevinnovak.nms_kotlin_template.utils.StringUtils
import org.bukkit.entity.Player

class MessageService {
    companion object {
        fun send(player: Player, msg: String) {
            var msg = StringUtils.color(msg)
            player.sendMessage(msg)
        }
    }
}