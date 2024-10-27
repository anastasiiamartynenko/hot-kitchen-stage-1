package hotkitchen.controllers

import hotkitchen.repositories.UserRepository
import hotkitchen.requests.LogInUser
import hotkitchen.requests.RegisterUser
import io.ktor.http.HttpStatusCode
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*

class UserController {
    private val userRepository = UserRepository()

    suspend fun registerUser(call: ApplicationCall) {
        val request = call.receive<RegisterUser>()

        if (userRepository.userExists(request.email)) {
            return call.respond(
                HttpStatusCode.Forbidden,
                hashMapOf("status" to "Registration failed")
            )
        }

        userRepository.registerUser(request)
        return call.respond(
            HttpStatusCode.OK,
            hashMapOf("status" to "Signed Up")
        )
    }

    suspend fun signInUser(call: ApplicationCall) {
        val request = call.receive<LogInUser>()
        val foundUser = userRepository.getUser(request.email)

        if (
            foundUser == null ||
            foundUser.password != request.password
        ) return call.respond(
            HttpStatusCode.Forbidden,
            hashMapOf("status" to "Authorization failed")
        )

        return call.respond(
            HttpStatusCode.OK,
            hashMapOf("status" to "Signed In")
        )
    }
}