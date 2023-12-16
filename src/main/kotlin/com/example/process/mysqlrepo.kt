package com.example.process

import com.example.database.database
import com.example.testdata.postdata
import com.example.testdata.user

class mysqlrepo : userprocess {

    private val database = database()


    override fun getalluser(): List<user> {

        return database.getalluser()
            .map { user(it.id, it.name, it.email , it.password ) }
    }

    override fun getoneuser(id: Int): user? {
        return database.getoneuser(id)
            ?.let { user(it.id, it.name, it.email , it.password ) }
    }

    override fun adduser(add: postdata): user {
        return database.adduser(add)
    }

    override fun deleteuse(id: Int): Boolean {
        return database.deleteuse(id)
    }
}