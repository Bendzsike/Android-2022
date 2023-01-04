package com.example.tracker.ui.groups

import com.google.gson.annotations.SerializedName

data class GetDepartmentsResponse(
    @SerializedName("ID")
    val departmentId : Int,
    @SerializedName("name")
    val departmentName: String
)