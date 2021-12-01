package com.yt8492.todokotless

import io.kotless.dsl.ktor.KotlessAWS
import io.ktor.application.*
import io.ktor.application.Application
import io.ktor.response.*
import io.ktor.routing.*

class Application : KotlessAWS() {
    override fun prepare(app: Application) {
        app.routing {
            get("/hello") {
                call.respondText("Hello world!")
            }
            get("/greet") {
                call.respondText("Hello Kotless!")
            }
        }
    }
}
