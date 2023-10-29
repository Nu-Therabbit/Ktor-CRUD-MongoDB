package com.example.data

import com.example.model.RegisterUser
import com.example.model.User
import org.litote.kmongo.coroutine.CoroutineCollection
import org.litote.kmongo.eq

class MongoUserDataSource(private val collection: CoroutineCollection<User>) : UserDataSource {
    override suspend fun getAllUsers(): List<User> {
        return collection.find().toList()
    }

    override suspend fun insert(user: RegisterUser): String {
        val newUser = User(email = user.email)
        collection.insertOne(newUser)
        return newUser.id
    }

    override suspend fun getUserById(id: String?): User {
        val user = collection.findOneById(User::id eq id)
        user ?: throw Exception("User not found with id : ($id)")
        return user
    }

    override suspend fun getUserByEmail(email: String): User {
        val user = collection.findOne(User::email eq email)
        user ?: throw Exception("User not found with email : ($email)")
        return user
    }
}