package com.example.data

import com.example.domain.UserRepository
import com.example.model.RegisterUser
import com.example.model.User

class UserRepositoryImpl(private val localUserDataSource: MongoUserDataSource) : UserRepository {
    override fun sayHello(): String {
        return "Hello World!"
    }

    override suspend fun getAll(): List<User> {
        return localUserDataSource.getAllUsers()
    }

    override suspend fun add(user: RegisterUser): String {
        return localUserDataSource.insert(user)
    }

    override suspend fun getUserById(id: String?): User {
        TODO("Not yet implemented")
    }
}