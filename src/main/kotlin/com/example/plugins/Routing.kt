package com.example.plugins

import com.example.domain.UserService
import com.example.model.RegisterUser
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import org.koin.ktor.ext.inject

fun Application.configureRouting() {
    val service by inject<UserService>()
    routing {
        get("/") {
            call.respondText(service.sayHello())
        }
        get("/user/{id}") {
            val id = call.parameters["id"]
            val user = service.getUserById(id)
            call.respond(HttpStatusCode.OK)
        }
        get("/users") {
            val result = service.getAll()
            call.respond(HttpStatusCode.OK, result)
        }
        post<RegisterUser>("/user") {
            val id = service.add(it)
            call.respond(HttpStatusCode.Created, mapOf("id" to id))
        }
    }
}
