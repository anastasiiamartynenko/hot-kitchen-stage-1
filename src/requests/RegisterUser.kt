package hotkitchen.requests

import kotlinx.serialization.Serializable

@Serializable
data class RegisterUser(
    val email: String,
    val userType: String,
    val password: String,
) {
    //
}