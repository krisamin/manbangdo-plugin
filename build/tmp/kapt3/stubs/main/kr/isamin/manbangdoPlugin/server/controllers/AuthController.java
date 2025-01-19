package kr.isamin.manbangdoPlugin.server.controllers;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007\u00a8\u0006\b"}, d2 = {"Lkr/isamin/manbangdoPlugin/server/controllers/AuthController;", "", "()V", "login", "", "ctx", "Lio/javalin/http/Context;", "register", "manbangdo-plugin"})
public final class AuthController {
    @org.jetbrains.annotations.NotNull()
    public static final kr.isamin.manbangdoPlugin.server.controllers.AuthController INSTANCE = null;
    
    private AuthController() {
        super();
    }
    
    @io.javalin.openapi.OpenApi(tags = {"Auth"}, path = "/auth/login", methods = {io.javalin.openapi.HttpMethod.GET}, requestBody = @io.javalin.openapi.OpenApiRequestBody(content = {@io.javalin.openapi.OpenApiContent(from = kr.isamin.manbangdoPlugin.server.controllers.LoginRequest.class)}), responses = {@io.javalin.openapi.OpenApiResponse(status = "200", content = {@io.javalin.openapi.OpenApiContent(from = kr.isamin.manbangdoPlugin.server.services.TokenResponse.class)})})
    public final void login(@org.jetbrains.annotations.NotNull()
    io.javalin.http.Context ctx) {
    }
    
    @io.javalin.openapi.OpenApi(tags = {"Auth"}, path = "/auth/register", methods = {io.javalin.openapi.HttpMethod.GET}, requestBody = @io.javalin.openapi.OpenApiRequestBody(content = {@io.javalin.openapi.OpenApiContent(from = kr.isamin.manbangdoPlugin.server.controllers.RegisterRequest.class)}), responses = {@io.javalin.openapi.OpenApiResponse(status = "200", content = {@io.javalin.openapi.OpenApiContent(from = kr.isamin.manbangdoPlugin.server.services.TokenResponse.class)})})
    public final void register(@org.jetbrains.annotations.NotNull()
    io.javalin.http.Context ctx) {
    }
}