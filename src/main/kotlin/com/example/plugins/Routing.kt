@file:Suppress("DEPRECATION")

package com.example.plugins

import com.example.process.memoryuserprocess
import com.example.process.mysqlrepo
import com.example.process.userprocess
import com.example.testdata.postdata
import com.example.testdata.user
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.http.content.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*




fun Application.configureRouting() {
    routing {

val memory:userprocess=mysqlrepo()

        get("/") {
            call.respondText("Hello World!")
        }

        get("/user"){
            call.respond(memory.getalluser())
        }

        get("/user/{id}"){
            val id=call.parameters["id"]?.toIntOrNull()

         if (id == null){

             call.respond(HttpStatusCode.BadRequest,"error")
             return@get
         }

            var data=memory.getoneuser(id)
            if (data == null){
                call.respond(HttpStatusCode.NotFound,"no data")
            }else{
                call.respond(data)
            }

        }


        post("/user") {
            val data = call.receive<postdata>()
            val u = memory.adduser(data)
            call.respond(u)
        }


        delete("/user/{id}"){
            val id=call.parameters["id"]?.toIntOrNull()

            if (id == null){

                call.respond(HttpStatusCode.BadRequest,"error")
                return@delete
            }
            val delete=memory.deleteuse(id)
            if (delete){
                call.respond(HttpStatusCode.OK)
            }else{
                call.respond(HttpStatusCode.NotFound,"delete error")
            }
        }


        // Static plugin. Try to access `/static/index.html`
        static("/static") {
            resources("static")
        }
    }
}
