package com.example.process

import com.example.testdata.postdata
import com.example.testdata.user

interface userprocess {

    fun getalluser() : List<user>

    fun getoneuser(id:Int) : user?

    fun adduser(add : postdata):user

    fun deleteuse(id: Int):Boolean
}
