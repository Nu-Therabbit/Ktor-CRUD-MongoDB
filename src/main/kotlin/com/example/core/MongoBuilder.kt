package com.example.core

import com.mongodb.ConnectionString
import org.litote.kmongo.coroutine.CoroutineDatabase
import org.litote.kmongo.coroutine.coroutine
import org.litote.kmongo.reactivestreams.KMongo

class MongoBuilder {
    fun build(): CoroutineDatabase {
        val client = KMongo.createClient(ConnectionString("mongodb://localhost:27017/ktor-auth")).coroutine
        return client.getDatabase("ktor-auth")
    }
}