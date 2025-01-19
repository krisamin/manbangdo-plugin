package kr.isamin.manbangdoPlugin.server

import io.javalin.Javalin
import io.javalin.openapi.plugin.OpenApiPlugin
import io.javalin.openapi.plugin.redoc.ReDocPlugin
import io.javalin.openapi.plugin.swagger.SwaggerPlugin
import kr.isamin.manbangdoPlugin.ManbangdoPlugin
import kr.isamin.manbangdoPlugin.server.routes.Register

object ServerApp {
    private lateinit var app: Javalin
    private lateinit var plugin: ManbangdoPlugin

    fun enable() {
        this.plugin = ManbangdoPlugin.plugin
        this.plugin.logger.info("[Server] 활성화중")

        app = Javalin.create { config ->
            config.showJavalinBanner = false
            config.registerPlugin(OpenApiPlugin{})
            config.registerPlugin(SwaggerPlugin{})
            config.registerPlugin(ReDocPlugin{})
            config.router.apiBuilder { Register.register() }
        }.start(8080)

        this.plugin.logger.info("[Server] 활성화됨")
    }

    fun disable() {
        this.plugin.logger.info("[Server] 비활성화중")

        app.stop()

        this.plugin.logger.info("[Server] 비활성화됨")
    }
}