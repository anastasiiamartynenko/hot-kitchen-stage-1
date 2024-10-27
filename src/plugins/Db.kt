package hotkitchen.plugins

import hotkitchen.entities.Users
import io.ktor.server.application.Application
import org.jetbrains.exposed.sql.Database
import org.jetbrains.exposed.sql.SchemaUtils
import org.jetbrains.exposed.sql.transactions.transaction

fun Application.configureDb() {
    val config = environment.config
    val dbUrl = config.property("ktor.database.url").getString()
    val dbDriver = config.property("ktor.database.driver").getString()
    val dbUser = config.property("ktor.database.user").getString()
    val dbPassword = config.property("ktor.database.password").getString()

    Database.connect(url = dbUrl, driver = dbDriver, user = dbUser, password = dbPassword)

    transaction {
        SchemaUtils.create(Users)
    }
}