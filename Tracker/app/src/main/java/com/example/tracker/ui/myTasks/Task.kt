package com.example.tracker.ui.myTasks

import java.util.*

data class Task(
    val taskId : Int,
    val title : String,
    val groupId : Int,
    val createdAt : Date,
    val createdBy: Int,
    val assignee : Int,
    val deadline: Date,
    val status : TaskStatus,
    val priority: TaskPriority,
    val description: String,
    val progress: Int
)
