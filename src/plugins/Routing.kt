package hotkitchen.plugins

import hotkitchen.routes.userRoutes
import io.ktor.server.application.Application
import io.ktor.server.routing.routing

fun Application.configureRouting() {
    routing {
        userRoutes()
    }
}