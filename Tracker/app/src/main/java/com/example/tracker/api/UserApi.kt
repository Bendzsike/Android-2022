package com.example.tracker.api

import com.example.tracker.api.login.LoginRequest
import com.example.tracker.api.login.LoginResponse
import com.example.tracker.api.user.UserResponse
import com.example.tracker.ui.groups.GetDepartmentsResponse
import com.example.tracker.ui.myTasks.CreateTaskRequest
import com.example.tracker.ui.myTasks.GetTasksResponse
import com.example.tracker.ui.users.GetCurrentUserResponse
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

    @GET("/users")
    suspend fun getUsers(@Header("token") token: String): Response<List<GetCurrentUserResponse>>

    @POST("/task/create")
    suspend fun createTask(@Header("token") token: String,@Body createTaskRequest: CreateTaskRequest) : Response<String>

    @GET("/task/getTasks")
    suspend fun getTasks(@Header("token") token:String) : Response<List<GetTasksResponse>>

    @GET("/department")
    suspend fun getDepartments(@Header("token") token:String) : Response<List<GetDepartmentsResponse>>

//    @POST("/users/updateProfile")
//    suspend fun updateProfile(@Header("token") token:String,@Body updateProfileRequest: UpdateProfileRequest): Response<String>

    companion object {
        fun getApi(): UserApi? {
            return ApiClient.client?.create(UserApi::class.java)
        }
    }
}