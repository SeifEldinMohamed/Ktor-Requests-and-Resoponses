package com.example.plugins

import io.ktor.server.application.*
import io.ktor.server.http.content.*
import io.ktor.server.routing.*

fun Application.routingStaticContent() {
    routing{
        static {
//            resource("test.txt")
//            resource("mr_android.png")
            resources("assets")
        }
    }
}