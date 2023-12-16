package com.example.process

import com.example.testdata.postdata
import com.example.testdata.user

class memoryuserprocess :userprocess {

   private val userdata= mutableListOf<user>()


    override fun getalluser(): List<user> {
        return userdata
    }

    override fun getoneuser(id: Int): user? {
        return userdata.firstOrNull { it.id == id }
    }



    override fun adduser(add: postdata): user {

        val data=user(
            id=userdata.size+1,
            name=add.name,
            email=add.email,
            password=add.password
        )
        userdata.add(data)

        return data
    }

    override fun deleteuse(id: Int): Boolean {
     return userdata.removeIf { it.id == id }
    }



}