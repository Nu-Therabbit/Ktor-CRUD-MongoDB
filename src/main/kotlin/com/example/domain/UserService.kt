package com.example.domain

import com.example.model.RegisterUser
import com.example.model.User

class UserService(private val userRepository: UserRepository) {
    fun sayHello(): String {
        return userRepository.sayHello()
    }

    suspend fun getAll(): List<User> {
        return userRepository.getAll()
    }

    suspend fun add(user: RegisterUser): String {
        return userRepository.add(user)
    }

    suspend fun getUserById(id: String?): User {
        return userRepository.getUserById(id)
    }
}