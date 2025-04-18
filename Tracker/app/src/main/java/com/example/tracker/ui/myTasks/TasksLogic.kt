package com.example.tracker.ui.myTasks

import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import com.example.tracker.repo.TaskRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch
import java.util.*

data class AllMyTasks(
    var tasks : MutableList<Task> = mutableListOf()
)

val uistate = MutableLiveData(AllMyTasks())

fun getTaskById(id: Int):Task?{
    for (t in uistate.value!!.tasks){
        if(t.taskId == id){
            return t
        }
    }
    return null
}

fun getMyTasks(token: String){
    val taskRepo = TaskRepository()
    CoroutineScope(IO).launch {
        try {
            val response = taskRepo.getTasks(token = token)
            if (response!!.isSuccessful){
                val responses = response.body().toString().trim().split("),")
                Log.i("RESPONSES",responses.toString())
                for(r in responses){
                    Log.i("Task responses", r)
                    val currentResponse = r.split(",")
                    val tempID = currentResponse[0].split("=")[1]
                    val tempTitle = currentResponse[1].split("=")[1]
                    var tempDesc = currentResponse[2].split("=")[1]
                    val tempCreatedAt = currentResponse[3].split("=")[1]
                    val tempCreator = currentResponse[4].split("=")[1]
                    val tempAssignedTo = currentResponse[5].split("=")[1]
                    val tempPrio = currentResponse[6].split("=")[1]
                    val tempDeadline = currentResponse[7].split("=")[1]
                    val tempDepartment = currentResponse[8].split("=")[1]
                    val tempStatus = currentResponse[9].split("=")[1]
                    var tempProgress: String
                    if (r == responses.last()){
                        tempProgress = currentResponse[10].split("=")[1].dropLast(2)
                    }else{
                        tempProgress = currentResponse[10].split("=")[1]
                    }
                    var status: TaskStatus = TaskStatus.NEW
                    when(tempStatus.toInt()){
                        0->status = TaskStatus.NEW
                        1->status = TaskStatus.IN_PROGRESS
                        2->status = TaskStatus.DONE
                        3->status = TaskStatus.BLOCKED
                    }
                    var priority: TaskPriority = TaskPriority.LOW
                    when(tempPrio.toInt()){
                        1->priority = TaskPriority.LOW
                        2->priority = TaskPriority.MEDIUM
                        3->priority = TaskPriority.HIGH
                    }
                    uistate.value?.tasks!!.add(Task(tempID.toInt(),tempTitle,tempDepartment.toInt(),
                        Date(tempCreatedAt.toLong()),tempCreator.toInt(),tempAssignedTo.toInt(),Date(tempDeadline.toLong()),
                        status,priority,tempDesc,tempProgress.toInt())
                    )
                }
                for(t in uistate.value!!.tasks){
                    Log.i("TasksVM", t.toString())
                }
            }
        }catch (ex: Exception){
            Log.i("Exception",ex.message,ex)
        }
    }
}

fun createTask(context: Context, token:String, taskRequest: CreateTaskRequest){
    val taskRepo = TaskRepository()
    CoroutineScope(IO).launch {
        try {
            val response = taskRepo.createTask(token,taskRequest)
            if (response!!.isSuccessful){
                Toast.makeText(context, "Task created successfully!", Toast.LENGTH_LONG).show()
            }
        }catch (ex: Exception){
            Log.i("Exception",ex.message,ex)
        }
    }
}