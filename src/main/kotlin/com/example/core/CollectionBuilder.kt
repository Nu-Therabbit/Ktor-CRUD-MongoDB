package com.example.core

import com.example.model.User
import org.litote.kmongo.coroutine.CoroutineCollection
import org.litote.kmongo.coroutine.CoroutineDatabase

class CollectionBuilder(private val database: CoroutineDatabase) {
    fun buildUser(): CoroutineCollection<User> {
        return database.getCollection<User>("users")
    }
}