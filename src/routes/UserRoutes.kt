package hotkitchen.routes

import hotkitchen.controllers.UserController
import io.ktor.server.application.*
import io.ktor.server.routing.*

fun Route.userRoutes() {
    val userController = UserController()

    post("/signup") { userController.registerUser(call) }
    post("/signin") { userController.signInUser(call) }

}