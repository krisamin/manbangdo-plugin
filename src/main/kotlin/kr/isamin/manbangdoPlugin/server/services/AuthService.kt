package kr.isamin.manbangdoPlugin.server.services

import com.auth0.jwt.JWT
import io.javalin.http.ForbiddenResponse
import io.javalin.http.NotFoundResponse
import io.javalin.http.UnauthorizedResponse
import kr.isamin.manbangdoPlugin.database.schemas.User
import kr.isamin.manbangdoPlugin.database.schemas.Users
import kr.isamin.manbangdoPlugin.server.libs.MicrosoftAuth
import kr.isamin.manbangdoPlugin.server.libs.TokenManager
import org.jetbrains.exposed.sql.insert
import org.jetbrains.exposed.sql.transactions.transaction
import java.util.*

data class TokenResponse(
    val accessToken: String,
    val refreshToken: String,
)

object AuthService {
    private fun getMinecraftToken(token: String): String {
        return MicrosoftAuth.xboxLiveAuth(token)
            .onFailure {
                println("Xbox Live 인증 실패: ${it.message}")
                throw UnauthorizedResponse("Xbox Live Auth Failed")
            }
            .mapCatching { xboxLiveAuth ->
                MicrosoftAuth.xstsAuth(xboxLiveAuth.Token).getOrThrow()
            }
            .onFailure {
                println("XSTS 인증 실패: ${it.message}")
                throw UnauthorizedResponse("XSTS Auth Failed")
            }
            .mapCatching { xstsAuth ->
                MicrosoftAuth.minecraftAuth(
                    token = xstsAuth.Token,
                    uhs = xstsAuth.DisplayClaims.xui[0].uhs
                ).getOrThrow()
            }
            .map { minecraftAuth ->
                minecraftAuth.access_token
            }
            .getOrElse {
                println("Minecraft 인증 실패: ${it.message}")
                throw UnauthorizedResponse("Minecraft Auth Failed")
            }
    }

    private fun getMinecraftUUID(minecraftToken: String): UUID {
        val jwt = JWT.decode(minecraftToken)
        val profiles = jwt.getClaim("profiles").asMap()
        val uuidString = profiles?.get("mc") as String
        return UUID.fromString(uuidString)
    }

    private fun getUser(uuid: UUID): User? {
        return transaction { User.findById(uuid) }
    }

    private fun getToken(uuid: UUID): TokenResponse {
        val user = getUser(uuid) ?: throw NotFoundResponse("User not found")

        return TokenResponse(
            accessToken = TokenManager.createAccessToken(user),
            refreshToken = TokenManager.createRefreshToken(user)
        )
    }

    fun login(token: String): TokenResponse {
        val minecraftToken = getMinecraftToken(token)
        val uuid = getMinecraftUUID(minecraftToken)

        getUser(uuid) ?: throw NotFoundResponse("User not found")
        return getToken(uuid)
    }

    fun register(token: String, nameString: String): TokenResponse {
        val minecraftToken = getMinecraftToken(token)
        val uuid = getMinecraftUUID(minecraftToken)

        val userExists = getUser(uuid)
        if(userExists != null) throw ForbiddenResponse("User Already Exists")

        transaction {
            Users.insert {
                it[id] = uuid
                it[name] = nameString
            }
        }

        return getToken(uuid)
    }
}