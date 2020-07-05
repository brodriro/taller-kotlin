package com.example.curso_kotlin.network

import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface Service {
    @GET("profile")
    suspend fun getProfile(): Response<UserResponse>

    @GET("posts")
    suspend fun getPosts(): Response<List<PostReponse>>

    @POST("post/save")
    suspend fun savePost(@Body image : String, @Body comment : String, @Body username: String) : Response<List<PostReponse>>

}