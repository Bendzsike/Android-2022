package com.example.tracker.repo

import com.example.tracker.api.login.LoginRequest
import com.example.tracker.api.login.LoginResponse
import com.example.tracker.api.UserApi
import com.example.tracker.api.user.UserResponse
import retrofit2.Response


class UserRepository {
    suspend fun loginUser(loginRequest: LoginRequest): Response<LoginResponse>? {
        return  UserApi.getApi()?.loginUser(loginRequest = loginRequest)
    }

    suspend fun getCurrentUser(token: String): Response<UserResponse>? {
        return  UserApi.getApi()?.getCurrentUser(token = token)
    }
}