package com.yan.foia.unlogged.ui.fragments.login

import androidx.lifecycle.ViewModel

class LoginViewModel : ViewModel() {
    fun validateLoginData(email: String, password: String): Boolean {
        return email == "yancunha.dev@gmail.com" && password == "foia"
    }
}