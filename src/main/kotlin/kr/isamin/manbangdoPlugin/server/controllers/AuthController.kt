package kr.isamin.manbangdoPlugin.server.controllers

import com.fasterxml.jackson.annotation.JsonProperty
import io.javalin.http.Context
import io.javalin.http.bodyAsClass
import io.javalin.openapi.*
import kr.isamin.manbangdoPlugin.server.services.AuthService
import kr.isamin.manbangdoPlugin.server.services.TokenResponse

data class LoginRequest(
    @JsonProperty("token") val token: String
)

data class RegisterRequest(
    @JsonProperty("token") val token: String,
    @JsonProperty("name") val name: String
)

object AuthController {
    @OpenApi(
        tags = ["Auth"],
        path = "/auth/login",
        methods = [HttpMethod.GET],
        requestBody = OpenApiRequestBody([OpenApiContent(LoginRequest::class)]),
        responses = [OpenApiResponse("200", [OpenApiContent(TokenResponse::class)])]
    )
    fun login(ctx: Context) {
        val loginRequest = ctx.bodyAsClass<LoginRequest>()
        val result = AuthService.login(loginRequest.token)
        ctx.json(result)
    }

    @OpenApi(
        tags = ["Auth"],
        path = "/auth/register",
        methods = [HttpMethod.GET],
        requestBody = OpenApiRequestBody([OpenApiContent(RegisterRequest::class)]),
        responses = [OpenApiResponse("200", [OpenApiContent(TokenResponse::class)])]
    )
    fun register(ctx: Context) {
        val registerRequest = ctx.bodyAsClass<RegisterRequest>()
        val result = AuthService.register(registerRequest.token, registerRequest.name)
        ctx.json(result)
    }
}