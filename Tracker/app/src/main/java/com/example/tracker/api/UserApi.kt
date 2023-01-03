package com.example.tracker.api

import com.example.tracker.api.login.LoginRequest
import com.example.tracker.api.login.LoginResponse
import com.example.tracker.api.user.UserResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST


interface UserApi {

    @GET("/user")
    suspend fun getCurrentUser(@Header("token") token : String) : Response<UserResponse>

    @POST("/login")
    suspend fun loginUser(@Body loginRequest: LoginRequest): Response<LoginResponse>

    companion object {
        fun getApi(): UserApi? {
            return ApiClient.client?.create(UserApi::class.java)
        }
    }
}