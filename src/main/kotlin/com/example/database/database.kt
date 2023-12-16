package com.example.database

import com.example.testdata.postdata
import com.example.testdata.user
import org.ktorm.database.Database
import org.ktorm.dsl.delete
import org.ktorm.dsl.eq
import org.ktorm.dsl.insertAndGenerateKey
import org.ktorm.entity.firstOrNull
import org.ktorm.entity.sequenceOf
import org.ktorm.entity.toList


class database {


    // config
    private val hostname ="localhost"
    private val databaseName = "user"
    private val username = "root"
    private val password = ""

    // database
    private val ktormDatabase: Database

    init {
        val jdbcUrl = "jdbc:mysql://$hostname:3306/$databaseName?user=$username&password=$password&useSSL=false"
        ktormDatabase = Database.connect(jdbcUrl)
    }

    fun getalluser(): List<userdata> {
        return ktormDatabase.sequenceOf(datatable).toList()
    }

    fun getoneuser(id: Int): userdata? {
        return ktormDatabase.sequenceOf(datatable)
            .firstOrNull { it.id eq id }
    }

    fun adduser(add: postdata): user {
        val insertedId = ktormDatabase.insertAndGenerateKey(datatable) {
            set(datatable.name, add.name)
            set(datatable.email, add.email)
            set(datatable.password, add.password)
        } as Int

        return user(insertedId, add.name, add.email, add.password)

    }

    fun deleteuse(id: Int): Boolean {
        val deletedRows = ktormDatabase.delete(datatable) {
            it.id eq id
        }
        return deletedRows > 0
    }


}