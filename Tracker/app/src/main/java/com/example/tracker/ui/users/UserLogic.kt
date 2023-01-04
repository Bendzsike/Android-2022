package com.example.tracker.ui.users

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.tracker.repo.UserRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch

data class AllUsers(
    var users: MutableList<GetCurrentUserResponse> = mutableListOf()
)

val userUistate = MutableLiveData(AllUsers())


fun getAllUsers(token: String) {
    val userRepo = UserRepository()
    CoroutineScope(IO).launch {
        try {
            val response = userRepo.getUsers(usersRequest = token)
            if (response.isSuccessful) {
                val responses = response.body().toString().trim().split("),")
                for (r in responses) {
                    val currentResponse = r.split(",")
                    val tempID = currentResponse[0].split("=").get(1)
                    val tempLastName = currentResponse[1].split("=").get(1)
                    val tempFirstName = currentResponse[2].split("=").get(1)
                    val tempEmail = currentResponse[3].split("=").get(1)
                    val tempType = currentResponse[4].split("=").get(1)
                    val tempLocation = currentResponse[5].split("=").get(1)
                    val tempPN = currentResponse[6].split("=").get(1)
                    val tempDepId = currentResponse[7].split("=").get(1)
                    val tempImageUrl = currentResponse[8].split("=").get(1).dropLast(1)
                    userUistate.value!!.users.add(
                        GetCurrentUserResponse(
                            tempID.toInt(),
                            tempLastName,
                            tempFirstName,
                            tempEmail,
                            tempType.toInt(),
                            tempLocation,
                            tempPN,
                            tempDepId.toInt(),
                            tempImageUrl
                        )
                    )
                }
            }
        } catch (ex: Exception) {
            Log.i("UsersViewModel", ex.message, ex)
        }
    }
}


fun getName(ID: Int): String? {
    for (u in userUistate.value!!.users) {
        if (u.ID == ID) {
            return "${u.first_name} ${u.last_name}"
        }
    }
    return null
}

fun getImage(ID: Int): String? {
    for (u in userUistate.value!!.users) {
        if (u.ID == ID) {
            return u.image
        }
    }
    return null
}

fun getEmail(ID: Int): String? {
    for (u in userUistate.value!!.users) {
        if (u.ID == ID) {
            Log.i("getEmail", u.email)
            return u.email
        }
    }
    return null
}

fun getType(ID: Int): Int {
    for (u in userUistate.value!!.users) {
        if (u.ID == ID) {
            return u.type
        }
    }
    return 0
}

fun getLocation(ID: Int): String? {
    for (u in userUistate.value!!.users) {
        if (u.ID == ID) {
            return u.location
        }
    }
    return null
}

fun getPhoneNumber(ID: Int): String? {
    for (u in userUistate.value!!.users) {
        if (u.ID == ID) {
            return u.phone_number
        }
    }
    return null
}

fun getDepartmentId(ID: Int): Int {
    for (u in userUistate.value!!.users) {
        if (u.ID == ID) {
            return u.department_id
        }
    }
    return 0
}

fun getUserByDepartmentAndType(departmentId: Int, type: Int): Int {
    for (u in userUistate.value!!.users) {
        if (u.department_id == departmentId && u.type == type) {
            return u.ID
        }
    }
    return 0
}