package com.example.data

import com.example.model.RegisterUser
import com.example.model.User

interface UserDataSource {
    suspend fun getAllUsers(): List<User>
    suspend fun insert(user: RegisterUser): String
    suspend fun getUserById(id: String?): User
    suspend fun getUserByEmail(email: String): User
}