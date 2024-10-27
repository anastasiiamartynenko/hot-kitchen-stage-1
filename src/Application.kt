package hotkitchen


import hotkitchen.plugins.configureDb
import hotkitchen.plugins.configureRouting
import io.ktor.server.application.*
import io.ktor.server.plugins.contentnegotiation.*
import io.ktor.serialization.kotlinx.json.*
import io.ktor.server.netty.*

fun main(args: Array<String>): Unit = EngineMain.main(args)

fun Application.module() {
    configureDb()
    configureRouting()
    install(ContentNegotiation) {
        json()
    }
}