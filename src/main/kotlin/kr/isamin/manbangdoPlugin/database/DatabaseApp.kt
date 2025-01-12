package kr.isamin.manbangdoPlugin.database

import com.zaxxer.hikari.HikariConfig
import com.zaxxer.hikari.HikariDataSource
import kr.isamin.manbangdoPlugin.ManbangdoPlugin
import org.jetbrains.exposed.sql.Database
import org.jetbrains.exposed.sql.transactions.TransactionManager

object DatabaseApp {
    private lateinit var app: Database
    private lateinit var plugin: ManbangdoPlugin

    fun enable() {
        this.plugin = ManbangdoPlugin.plugin
        this.plugin.logger.info("[Database] 활성화중")

        val databaseUrl = this.plugin.config.getString("database.url")
        val databaseUsername = this.plugin.config.getString("database.username")
        val databasePassword = this.plugin.config.getString("database.password")

        val config = HikariConfig().apply {
            jdbcUrl = databaseUrl
            username = databaseUsername
            password = databasePassword
            driverClassName = "org.postgresql.Driver"
        }
        val source = HikariDataSource(config)

        try {
            app = Database.connect(source)

            this.plugin.logger.info("[Database] 활성화됨")
        } catch (e: Exception) {
            this.plugin.logger.warning("[Database] " + e.message)
            this.plugin.logger.info("[Database] 활성화 오류")
        }
    }

    fun disable() {
        this.plugin.logger.info("[Database] 비활성화중")

        if(::app.isInitialized) {
            TransactionManager.closeAndUnregister(app)

            this.plugin.logger.info("[Database] 비활성화됨")
        } else {
            this.plugin.logger.info("[Database] 비활성화 넘어감")
        }
    }
}