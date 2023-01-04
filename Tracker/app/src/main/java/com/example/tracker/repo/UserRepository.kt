package com.example.tracker.repo

import com.example.tracker.api.login.LoginRequest
import com.example.tracker.api.login.LoginResponse
import com.example.tracker.api.UserApi
import com.example.tracker.api.user.UserResponse
import com.example.tracker.ui.users.GetCurrentUserResponse
import retrofit2.Response


class UserRepository {
    suspend fun loginUser(loginRequest: LoginRequest): Response<LoginResponse>? {
        return  UserApi.getApi()?.loginUser(loginRequest = loginRequest)
    }

    suspend fun getCurrentUser(token: String): Response<UserResponse>? {
        return  UserApi.getApi()?.getCurrentUser(token = token)
    }

    suspend fun getUsers(usersRequest: String): Response<List<GetCurrentUserResponse>>{
        return UserApi.getApi()!!.getUsers(token = usersRequest)
    }

//    suspend fun updateProfile(token:String,updateProfileRequest: UpdateProfileRequest): Response<String>?{
//        return UserApi.getApi()?.updateProfile(token = token, updateProfileRequest = updateProfileRequest)
//    }
}