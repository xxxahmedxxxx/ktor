package com.example.database

import org.ktorm.entity.Entity
import org.ktorm.schema.Table
import org.ktorm.schema.boolean
import org.ktorm.schema.int
import org.ktorm.schema.varchar

object datatable: Table<userdata>("userdata") {

    val id = int("id").primaryKey().bindTo { it.id }
    val name = varchar("name").bindTo { it.name }
    val email = varchar("email").bindTo { it.email }
    val password = varchar("password").bindTo { it.password }
}

interface userdata: Entity<userdata> {

    companion object : Entity.Factory<userdata>()

    val id: Int
    val name: String
    val email:String
    val password:String


}