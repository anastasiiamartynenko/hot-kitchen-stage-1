package hotkitchen.repositories

import hotkitchen.entities.User
import hotkitchen.entities.Users
import hotkitchen.requests.RegisterUser
import org.jetbrains.exposed.sql.transactions.transaction

class UserRepository {
    fun getUser(id: Int): User? = transaction {
        User.find { Users.id eq id }.singleOrNull()
    }
    fun getUser(email: String): User? = transaction {
        User.find { Users.email eq email }.singleOrNull()
    }

    fun userExists(email: String): Boolean = getUser(email) != null

    fun registerUser(user : RegisterUser) = transaction {
        User.new {
            email = user.email
            userType = user.userType
            password = user.password
        }
    }
}