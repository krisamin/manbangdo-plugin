package kr.isamin.manbangdoPlugin.server.routes

import io.javalin.apibuilder.ApiBuilder.*
import kr.isamin.manbangdoPlugin.server.controllers.AuthController

object AuthRoutes {
    fun routes() {
        path("login") {
            post(AuthController::login)
        }
        path("register") {
            post(AuthController::register)
        }
    }
}