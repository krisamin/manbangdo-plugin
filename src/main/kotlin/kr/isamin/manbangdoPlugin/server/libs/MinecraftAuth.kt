package kr.isamin.manbangdoPlugin.server.libs

import com.google.gson.Gson
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.RequestBody.Companion.toRequestBody

data class XboxLiveAuthRequest(
    val RelyingParty: String = "http://auth.xboxlive.com",
    val TokenType: String = "JWT",
    val Properties: XboxLiveAuthProperties
)

data class XboxLiveAuthProperties(
    val AuthMethod: String = "RPS",
    val SiteName: String = "user.auth.xboxlive.com",
    val RpsTicket: String
)

data class XstsAuthRequest(
    val RelyingParty: String = "rp://api.minecraftservices.com/",
    val TokenType: String = "JWT",
    val Properties: XstsAuthProperties
)

data class XstsAuthProperties(
    val UserTokens: List<String>,
    val SandboxId: String = "RETAIL"
)

data class MinecraftAuthRequest(
    val identityToken: String
)

data class XboxAuthResponse(
    val Token: String,
    val DisplayClaims: DisplayClaims
)

data class DisplayClaims(
    val xui: List<Xui>
)

data class Xui(
    val uhs: String
)

data class MinecraftAuthResponse(
    val username: String,
    val access_token: String,
    val token_type: String,
    val expires_in: Int
)

object MicrosoftAuth {
    private val client = OkHttpClient()
    private val gson = Gson()

    private fun executeRequest(request: Request): Result<String> = runCatching {
        val response = client.newCall(request).execute()
        if (response.isSuccessful) {
            response.body?.string() ?: throw Exception("응답 본문이 비어있습니다")
        } else {
            throw Exception("HTTP 오류: ${response.code}")
        }
    }

    private fun <T> makeHttpRequest(
        url: String,
        requestBody: Any,
        responseClass: Class<T>
    ): Result<T> = runCatching {
        val request = Request.Builder()
            .url(url)
            .post(gson.toJson(requestBody).toRequestBody("application/json; charset=utf-8".toMediaType()))
            .build()

        executeRequest(request).map { responseBody ->
            gson.fromJson(responseBody, responseClass)
        }.getOrThrow()
    }

    fun xboxLiveAuth(token: String): Result<XboxAuthResponse> = makeHttpRequest(
        url = "https://user.auth.xboxlive.com/user/authenticate",
        requestBody = XboxLiveAuthRequest(
            Properties = XboxLiveAuthProperties(RpsTicket = "d=$token")
        ),
        responseClass = XboxAuthResponse::class.java
    )

    fun xstsAuth(token: String): Result<XboxAuthResponse> = makeHttpRequest(
        url = "https://xsts.auth.xboxlive.com/xsts/authorize",
        requestBody = XstsAuthRequest(
            Properties = XstsAuthProperties(UserTokens = listOf(token))
        ),
        responseClass = XboxAuthResponse::class.java
    )

    fun minecraftAuth(token: String, uhs: String): Result<MinecraftAuthResponse> = makeHttpRequest(
        url = "https://api.minecraftservices.com/authentication/login_with_xbox",
        requestBody = MinecraftAuthRequest(
            identityToken = "XBL3.0 x=$uhs;$token"
        ),
        responseClass = MinecraftAuthResponse::class.java
    )
}