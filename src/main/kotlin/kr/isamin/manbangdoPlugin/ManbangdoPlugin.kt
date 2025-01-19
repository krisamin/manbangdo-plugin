package kr.isamin.manbangdoPlugin

import kr.isamin.manbangdoPlugin.database.DatabaseApp
import kr.isamin.manbangdoPlugin.discord.DiscordApp
import kr.isamin.manbangdoPlugin.minecraft.MinecraftApp
import kr.isamin.manbangdoPlugin.server.ServerApp
import org.bukkit.plugin.java.JavaPlugin

class ManbangdoPlugin : JavaPlugin() {
    override fun onEnable() {
        plugin = this
        this.logger.info("==== 만방도 플러그인 활성화중 ====")

        this.saveDefaultConfig()

        DatabaseApp.enable()
        DiscordApp.enable()
        ServerApp.enable()
        MinecraftApp.enable()

        this.logger.info("==== 만방도 플러그인 활성화됨 ====")
    }

    override fun onDisable() {
        this.logger.info("==== 만방도 플러그인 비활성화중 ====")

        ServerApp.disable()
        DiscordApp.disable()
        DatabaseApp.disable()

        this.logger.info("==== 만방도 플러그인 비활성화됨 ====")
    }

    companion object {
        lateinit var plugin: ManbangdoPlugin
        private set
    }
}
