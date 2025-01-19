package kr.isamin.manbangdoPlugin.database.schemas;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007\u00a8\u0006\b"}, d2 = {"Lkr/isamin/manbangdoPlugin/database/schemas/Users;", "Lorg/jetbrains/exposed/dao/id/UUIDTable;", "()V", "name", "Lorg/jetbrains/exposed/sql/Column;", "", "getName", "()Lorg/jetbrains/exposed/sql/Column;", "manbangdo-plugin"})
public final class Users extends org.jetbrains.exposed.dao.id.UUIDTable {
    @org.jetbrains.annotations.NotNull()
    private static final org.jetbrains.exposed.sql.Column<java.lang.String> name = null;
    @org.jetbrains.annotations.NotNull()
    public static final kr.isamin.manbangdoPlugin.database.schemas.Users INSTANCE = null;
    
    private Users() {
        super(null, null);
    }
    
    @org.jetbrains.annotations.NotNull()
    public final org.jetbrains.exposed.sql.Column<java.lang.String> getName() {
        return null;
    }
}