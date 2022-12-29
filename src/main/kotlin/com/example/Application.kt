package com.example

import io.ktor.server.application.*
import com.example.plugins.*
import io.ktor.serialization.kotlinx.json.*
import io.ktor.server.plugins.contentnegotiation.*

fun main(args: Array<String>): Unit =
    io.ktor.server.netty.EngineMain.main(args)

@Suppress("unused")
fun Application.module() {
    install(ContentNegotiation){
        json()
    }
    // configureRouting()
    routingStaticContent()
}
