package me.kevinnovak.nms_kotlin_template.services

import org.bukkit.configuration.file.YamlConfiguration
import org.bukkit.plugin.java.JavaPlugin
import java.io.File
import java.nio.file.Files
import java.nio.file.Paths

class Config(private var plugin: JavaPlugin, var resourcePath: String, var dataPath: String) {
    private var file: File = Paths.get(this.plugin.dataFolder.absolutePath, dataPath).toFile()
    private var config: YamlConfiguration = YamlConfiguration()

    fun load() {
        if (!this.file.exists()) {
            this.file.parentFile.mkdirs()
            var stream = this.plugin.getResource(resourcePath)
            Files.copy(stream, this.file.toPath())
            stream?.close()
        }
        this.config = YamlConfiguration.loadConfiguration(this.file)
    }

    public fun save() {
        this.config.save(this.file)
    }

    fun getString(path: String): String? {
        return this.config.getString(path)
    }

    fun setString(path: String, value: String, save: Boolean = true) {
        this.config.set(path, value)
        if (save) {
            this.save()
        }
    }

    fun getStringList(path: String): List<String>? {
        return this.config.getStringList(path)
    }

    fun setStringList(path: String, value: List<String>, save: Boolean = true) {
        this.config.set(path, value)
        if (save) {
            this.save()
        }
    }

    fun getInt(path: String): Int? {
        return this.config.getInt(path)
    }

    fun setInt(path: String, value: Int, save: Boolean = true) {
        this.config.set(path, value)
        if (save) {
            this.save()
        }
    }

    fun getDouble(path: String): Double? {
        return this.config.getDouble(path)
    }

    fun setDouble(path: String, value: Double, save: Boolean = true) {
        this.config.set(path, value)
        if (save) {
            this.save()
        }
    }

    fun getBoolean(path: String): Boolean? {
        return this.config.getBoolean(path)
    }

    fun setBoolean(path: String, value: Boolean, save: Boolean = true) {
        this.config.set(path, value)
        if (save) {
            this.save()
        }
    }

    fun deleteValue(path: String) {
        this.config.set(path, null)
    }
}