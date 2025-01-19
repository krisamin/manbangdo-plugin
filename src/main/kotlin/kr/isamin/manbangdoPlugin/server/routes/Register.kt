package kr.isamin.manbangdoPlugin.server.routes

import io.javalin.apibuilder.ApiBuilder.*

object Register {
    fun register() {
        get("ping", { ctx -> ctx.result("pong!") })
        path("auth") { AuthRoutes.routes() }
    }
}