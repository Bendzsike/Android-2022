package com.example.tracker.ui.groups

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.tracker.repo.DepartmentsRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch

data class AllGroups(
    var groups: MutableList<GetDepartmentsResponse> = mutableListOf()
)

val groupUistate = MutableLiveData(AllGroups())

fun getGroupById(id:Int):String?{
    for(g in groupUistate.value!!.groups){
        if (g.departmentId==id){
            return g.departmentName
        }
    }
    return null
}

fun getDepartments(token: String) {
    val groupsRepo = DepartmentsRepository()
    CoroutineScope(IO).launch {
        try {
            val response = groupsRepo.getDepartments(token = token)
            if (response!!.isSuccessful) {
                val responses = response.body().toString().trim().split("),")
                for(r in responses){
                    val currentResponse = r.split(",")
                    val tempId=currentResponse[0].split("=")[1].toInt()
                    val tempName=currentResponse[1].split("=")[1]
                    groupUistate.value?.groups!!.add(GetDepartmentsResponse(tempId,tempName))
                }
            }
        } catch (ex: Exception) {
            Log.i("EXCEPTION", ex.message, ex)
        }
    }
}