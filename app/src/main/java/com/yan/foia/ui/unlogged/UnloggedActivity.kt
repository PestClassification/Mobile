package com.yan.foia.ui.unlogged

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.yan.foia.R
import com.yan.foia.ui.unlogged.fragments.welcome.WelcomeFragment

class UnloggedActivity : AppCompatActivity() {

    enum class problems {
        minCaracters, maxCaracters, dontHaveUpper,dontHaveLower,dontHaveSpecial, dontHaveNum, dontHaveProblems
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.unlogged_main)

        bntLogin.setOnClickListener {

            val password = /**IDBotton**/.text.toString().trim()

            val validationResult = pass_validator(password)
            when (validationResult) {
                problems.minCaracters -> /**IDBotton**/.error = "Sua senha deve conter no minimo 8 caracteres"
                problems.maxCaracters -> /**IDBotton**/.error = "Sua senha deve conter no maximo 32 caracteres"
                problems.dontHaveUpper -> /**IDBotton**/.error = "Sua senha deve conter no minimo 1 letra maiuscula"
                problems.dontHaveNum -> /**IDBotton**/.error = "Sua senha deve conter no minimo 1 numero "
                problems.dontHaveSpecial -> /**IDBotton**/.error = "Sua senha deve conter no minimo 1 caracter special"
                else -> { /* Passar para a próxima tela */ }
            }
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.unlogged)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        supportFragmentManager.beginTransaction()
            .replace(R.id.unlogged_fragment_container, WelcomeFragment(), null)
            .addToBackStack(null)
            .commit()
    }

    fun pass_validator(pass: String): problems = when {
        pass.length < 8 -> problems.minCaracters
        pass.length > 32 -> problems.maxCaracters
        !pass.any { it.isUpperCase() } -> problems.dontHaveUpper
        !pass.any { it.isLowerCase() } -> problems.dontHaveLower
        !pass.any { it.isDigit() } -> problems.dontHaveNum
        !pass.any { !it.isLetterOrDigit() } -> problems.dontHaveSpecial
        else -> problens.dontHaveProblens
    }


}
