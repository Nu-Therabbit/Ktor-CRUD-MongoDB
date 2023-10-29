package com.example.model

import org.bson.codecs.pojo.annotations.BsonId
import java.util.*

data class User(
    @BsonId
    val id: String = UUID.randomUUID().toString(),
    val email: String
)
