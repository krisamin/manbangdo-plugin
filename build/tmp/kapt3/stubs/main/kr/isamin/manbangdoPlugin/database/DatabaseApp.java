package kr.isamin.manbangdoPlugin.database;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0006\u0010\u0007\u001a\u00020\bJ\u0006\u0010\t\u001a\u00020\bJ\b\u0010\n\u001a\u00020\bH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000b"}, d2 = {"Lkr/isamin/manbangdoPlugin/database/DatabaseApp;", "", "()V", "app", "Lorg/jetbrains/exposed/sql/Database;", "plugin", "Lkr/isamin/manbangdoPlugin/ManbangdoPlugin;", "disable", "", "enable", "migrate", "manbangdo-plugin"})
public final class DatabaseApp {
    private static org.jetbrains.exposed.sql.Database app;
    private static kr.isamin.manbangdoPlugin.ManbangdoPlugin plugin;
    @org.jetbrains.annotations.NotNull()
    public static final kr.isamin.manbangdoPlugin.database.DatabaseApp INSTANCE = null;
    
    private DatabaseApp() {
        super();
    }
    
    public final void enable() {
    }
    
    public final void disable() {
    }
    
    private final void migrate() {
    }
}