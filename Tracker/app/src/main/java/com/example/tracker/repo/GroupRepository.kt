package com.example.tracker.repo

import com.example.tracker.api.UserApi
import com.example.tracker.ui.groups.GetDepartmentsResponse
import retrofit2.Response

class DepartmentsRepository {
    suspend fun getDepartments(token:String) : Response<List<GetDepartmentsResponse>>? {
        return UserApi.getApi()?.getDepartments(token = token)
    }
}