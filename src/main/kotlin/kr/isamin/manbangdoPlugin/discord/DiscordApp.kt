package kr.isamin.manbangdoPlugin.discord

import kr.isamin.manbangdoPlugin.ManbangdoPlugin
import net.dv8tion.jda.api.JDA
import net.dv8tion.jda.api.JDABuilder

object DiscordApp {
    private lateinit var app: JDA
    private lateinit var plugin: ManbangdoPlugin

    fun enable() {
        this.plugin = ManbangdoPlugin.plugin
        this.plugin.logger.info("[Discord] 활성화중")

        val builder = JDABuilder.createDefault(this.plugin.config.getString("discord.token"))

        try {
            this.app = builder.build()

            this.plugin.logger.info("[Discord] 활성화됨")
        } catch (e: Exception) {
            this.plugin.logger.warning("[Discord] " + e.message)
            this.plugin.logger.info("[Discord] 활성화 오류")
        }
    }

    fun disable() {
        this.plugin.logger.info("[Discord] 비활성화중")

        if (::app.isInitialized) {
            this.app.shutdown()

            this.plugin.logger.info("[Discord] 비활성화됨")
        } else {
            this.plugin.logger.info("[Discord] 비활성화 넘어감")
        }
    }
}