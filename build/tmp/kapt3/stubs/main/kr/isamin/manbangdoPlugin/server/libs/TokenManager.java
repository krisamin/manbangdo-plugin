package kr.isamin.manbangdoPlugin.server.libs;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nJ\u000e\u0010\u000b\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nR\u0016\u0010\u0003\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u0006\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\f"}, d2 = {"Lkr/isamin/manbangdoPlugin/server/libs/TokenManager;", "", "()V", "accessTokenAlgorithm", "Lcom/auth0/jwt/algorithms/Algorithm;", "kotlin.jvm.PlatformType", "refreshTokenAlgorithm", "createAccessToken", "", "user", "Lkr/isamin/manbangdoPlugin/database/schemas/User;", "createRefreshToken", "manbangdo-plugin"})
public final class TokenManager {
    private static final com.auth0.jwt.algorithms.Algorithm accessTokenAlgorithm = null;
    private static final com.auth0.jwt.algorithms.Algorithm refreshTokenAlgorithm = null;
    @org.jetbrains.annotations.NotNull()
    public static final kr.isamin.manbangdoPlugin.server.libs.TokenManager INSTANCE = null;
    
    private TokenManager() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String createAccessToken(@org.jetbrains.annotations.NotNull()
    kr.isamin.manbangdoPlugin.database.schemas.User user) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String createRefreshToken(@org.jetbrains.annotations.NotNull()
    kr.isamin.manbangdoPlugin.database.schemas.User user) {
        return null;
    }
}