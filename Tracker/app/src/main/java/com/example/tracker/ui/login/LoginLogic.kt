package com.example.tracker.ui.login

import android.content.SharedPreferences
import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.tracker.api.login.LoginRequest
import com.example.tracker.repo.UserRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch

val loginResult: MutableLiveData<LoginResult> = MutableLiveData()
private val userRepo = UserRepository()

fun login(email: String, password: String, sharedPreferences: SharedPreferences) {
    loginResult.postValue(LoginResult.LOADING)
    if(email.isNullOrEmpty() || password.isNullOrEmpty()){
        loginResult.postValue(LoginResult.INVALID_CREDENTIALS)
        return
    }
    CoroutineScope(IO).launch {
        try {
            val loginRequest = LoginRequest(email, password)
            val response = userRepo.loginUser(loginRequest = loginRequest)
            if (response?.isSuccessful == true) {
                Log.d("LoginLogic", "Login response ${response.body()}")
                saveData(response.body()!!.userId, response.body()!!.token, response.body()!!.deadline, sharedPreferences)
                loginResult.postValue(LoginResult.SUCCESS)
            } else {
                Log.d("LoginLogic", "Login error response ${response?.errorBody()}")
                loginResult.postValue(LoginResult.INVALID_CREDENTIALS)
            }

        } catch (ex: Exception) {
            Log.e("LoginLogic", ex.message, ex)
            loginResult.postValue(LoginResult.UNKNOWN_ERROR)
        }
    }
}

fun saveData(userId: Int, token: String, deadline: Long, sharedPreferences: SharedPreferences) {
    val editor: SharedPreferences.Editor = sharedPreferences.edit()
    editor.putInt("userId", userId)
    editor.putString("token", token)
    editor.putLong("deadline", deadline)
    editor.apply()
}

