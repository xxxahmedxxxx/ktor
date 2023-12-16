package com.example.testdata

import kotlinx.serialization.Serializable

@Serializable

data class user(
    val id:Int,
    val name:String,
    val email:String,
    val password:String
)
