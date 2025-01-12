package kr.isamin.manbangdoPlugin.server

import io.javalin.Javalin
import kr.isamin.manbangdoPlugin.ManbangdoPlugin

object ServerApp {
    private lateinit var app: Javalin
    private lateinit var plugin: ManbangdoPlugin

    fun enable() {
        this.plugin = ManbangdoPlugin.plugin
        this.plugin.logger.info("[Server] 활성화중")

        app = Javalin.create { config ->
            config.showJavalinBanner = false
        }.start(8080)

        app.get("/") { ctx ->
            ctx.result("Hello world!")
        }

        this.plugin.logger.info("[Server] 활성화됨")
    }

    fun disable() {
        this.plugin.logger.info("[Server] 비활성화중")

        app.stop()

        this.plugin.logger.info("[Server] 비활성화됨")
    }
}