package com.yan.foia.unlogged.control

class LoginValidator {
    fun validadeLoginData(email: String, password: String): Boolean {
        return email == "yancunha.dev@gmail.com" && password == "foia"
    }
}