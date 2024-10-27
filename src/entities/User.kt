package hotkitchen.entities

import org.jetbrains.exposed.dao.IntEntity
import org.jetbrains.exposed.dao.IntEntityClass
import org.jetbrains.exposed.dao.id.EntityID
import org.jetbrains.exposed.dao.id.IntIdTable

object Users: IntIdTable() {
    val email = varchar("email", 255).uniqueIndex()
    val userType = varchar("user_type", 255)
    val password = varchar("password", 255)
}

class User(id: EntityID<Int>) : IntEntity(id) {
    companion object: IntEntityClass<User>(Users)

    var email by Users.email
    var userType by Users.userType
    var password by Users.password
}
