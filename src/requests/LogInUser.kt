package hotkitchen.requests

import kotlinx.serialization.Serializable

@Serializable
data class LogInUser (
    val email: String,
    val password: String
) {
}