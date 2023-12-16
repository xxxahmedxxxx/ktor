package com.example.testdata

import kotlinx.serialization.Serializable

@Serializable
data class postdata(
    val name:String,
    val email:String,
    val password:String
)
