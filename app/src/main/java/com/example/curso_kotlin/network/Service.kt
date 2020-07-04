package com.example.curso_kotlin.network

import retrofit2.Response
import retrofit2.http.GET

interface Service {
    @GET("profile")
    suspend fun getProfile() :Response<UserResponse>


}