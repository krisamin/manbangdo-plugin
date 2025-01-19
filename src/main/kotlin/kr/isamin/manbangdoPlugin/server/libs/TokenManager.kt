package kr.isamin.manbangdoPlugin.server.libs

import com.auth0.jwt.JWT
import com.auth0.jwt.algorithms.Algorithm
import kr.isamin.manbangdoPlugin.database.schemas.User

object TokenManager {
    private val accessTokenAlgorithm = Algorithm.HMAC512("access-key")
    private val refreshTokenAlgorithm = Algorithm.HMAC512("refresh-key")

    fun createAccessToken(user: User): String {
        return JWT.create()
            .withClaim("id", user.id.toString())
            .withClaim("name", user.name)
            .sign(accessTokenAlgorithm)
    }

    fun createRefreshToken(user: User): String {
        return JWT.create()
            .withClaim("id", user.id.toString())
            .withClaim("name", user.name)
            .sign(refreshTokenAlgorithm)
    }
}