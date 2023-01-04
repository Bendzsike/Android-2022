package com.example.tracker.repo

import com.example.tracker.api.UserApi
import com.example.tracker.ui.myTasks.CreateTaskRequest
import com.example.tracker.ui.myTasks.GetTasksResponse
import retrofit2.Response

class TaskRepository {
    suspend fun createTask(token:String,createTaskRequest: CreateTaskRequest): Response<String>? {
        return UserApi.getApi()?.createTask(token = token, createTaskRequest = createTaskRequest)
    }

    suspend fun getTasks(token:String): Response<List<GetTasksResponse>>?{
        return UserApi.getApi()?.getTasks(token = token)
    }
}