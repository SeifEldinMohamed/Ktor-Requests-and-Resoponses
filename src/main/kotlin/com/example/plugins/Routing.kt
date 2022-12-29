package com.example.plugins

import io.ktor.server.routing.*
import io.ktor.http.*
import io.ktor.serialization.kotlinx.json.*
import io.ktor.server.application.*
import io.ktor.server.plugins.contentnegotiation.*
import io.ktor.server.response.*
import io.ktor.server.request.*
import kotlinx.serialization.Serializable

fun Application.configureRouting() {


    routing {
        get("/") {
            call.respondText("Hello World!")
        }
        get("/users/{username}") {
            val username = call.parameters["username"]
            val header = call.request.headers["Connection"]
            if (username == "Admin") {
                call.response.header(name = "CustomHeader", value = "Admin")
                call.respond(message = "Hello Admin", status = HttpStatusCode.OK)
            }
            call.respondText("Hello $username with header: $header")
        }
        get("/user") {
            val name = call.request.queryParameters["name"]
            val age = call.request.queryParameters["age"]
            call.respondText("Hello my name is $name, I'm $age years old")
        }
        get("/person") {
            try {
                val person = Person(name = "Seif", age = "21")
                call.respond(message = person, status = HttpStatusCode.OK)
            } catch (e: Exception) {
                call.respond(message = e.message.toString(), status = HttpStatusCode.BadRequest)
            }
        }
    }
}

@Serializable
data class Person(
    val name: String,
    val age: String
)
