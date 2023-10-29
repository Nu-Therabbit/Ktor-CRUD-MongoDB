package com.example.domain

import com.example.model.RegisterUser
import com.example.model.User

interface UserRepository {
    fun sayHello(): String
    suspend fun getAll(): List<User>
    suspend fun add(user: RegisterUser): String
    suspend fun getUserById(id: String?): User
}