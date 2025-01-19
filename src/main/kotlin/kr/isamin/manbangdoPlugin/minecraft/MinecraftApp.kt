package kr.isamin.manbangdoPlugin.minecraft

import kr.isamin.manbangdoPlugin.ManbangdoPlugin

object MinecraftApp {
    private lateinit var plugin: ManbangdoPlugin

    fun enable() {
        this.plugin = ManbangdoPlugin.plugin
    }
}