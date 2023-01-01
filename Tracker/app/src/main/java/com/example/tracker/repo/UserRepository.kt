package com.example.tracker.repo

import com.example.tracker.api.login.LoginRequest
import com.example.tracker.api.login.LoginResponse
import com.example.tracker.api.login.UserApi
import retrofit2.Response


class UserRepository {
    suspend fun loginUser(loginRequest: LoginRequest): Response<LoginResponse>? {
        return  UserApi.getApi()?.loginUser(loginRequest = loginRequest)
    }
}