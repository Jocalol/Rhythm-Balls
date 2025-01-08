package com.example.rhythmballs

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.launch


data class RegisterState(
    val email: String = "",
    val password: String = "",
    val isLoading: Boolean = false,
    var error: String? = null
)

class RegisterViewModel : ViewModel() {

    var state = mutableStateOf(RegisterState())


    private val auth: FirebaseAuth = FirebaseAuth.getInstance()


    fun onEmailChange(email: String) {
        state.value = state.value.copy(email = email)
    }

    fun onPasswordChange(password: String) {
        state.value = state.value.copy(password = password)
    }

    fun onRegisterClick(onRegisterSuccess: ()->Unit) {
        viewModelScope.launch {
            auth.createUserWithEmailAndPassword(state.value.email, state.value.password)
                .addOnCompleteListener { task ->
                    if (!task.isSuccessful) {
                        state.value.error = task.exception?.message.orEmpty()
                    } else {
                        onRegisterSuccess()
                    }
                }
        }
    }
}