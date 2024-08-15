package com.yan.foia.unlogged.ui.fragments.login

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageButton
import android.widget.ToggleButton
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout
import com.google.android.material.textfield.TextInputLayout.END_ICON_PASSWORD_TOGGLE
import com.yan.foia.R
import com.yan.foia.databinding.FragmentLoginBinding
import com.yan.foia.logged.LoggedActivity

class LoginFragment : Fragment() {

    private lateinit var backButton: ImageButton
    private lateinit var eyeButton: ToggleButton
    private lateinit var eyeButtonClick: ConstraintLayout

    private lateinit var emailInput: TextInputLayout
    private lateinit var passwordInput: TextInputLayout

    private lateinit var emailInputA: TextInputEditText
    private lateinit var passwordInputB: TextInputEditText

    private lateinit var loginButton: Button

    private var _binding: FragmentLoginBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        val loginViewModel = ViewModelProvider(this)[LoginViewModel::class.java]

        _binding = FragmentLoginBinding.inflate(layoutInflater, container, false)
        val root: View = binding.root

        backButton = binding.loginBackButton
        backButton.setOnClickListener { _ ->
            parentFragmentManager.popBackStack()
        }


        passwordInput = binding.passwordTextLayout
        emailInput = binding.emailTextLayout
        passwordInput.endIconMode = END_ICON_PASSWORD_TOGGLE
//        eyeButton = binding.eyeButton
//        eyeButtonClick = binding.eyeButtonClick
//        eyeButtonClick.setOnClickListener { _ ->
//            eyeButton.isChecked = !eyeButton.isChecked
//        }

        emailInputA = binding.emailTextInput
        passwordInputB = binding.passwordTextInput

        loginButton = binding.loginButton
        loginButton.setOnClickListener { _ ->
            if(loginViewModel.validateLoginData(emailInputA.text.toString(), passwordInputB.text.toString())) {
                println(emailInputA.text.toString())
                val newActivity = Intent(requireActivity(), LoggedActivity::class.java)
                startActivity(newActivity)
            }
        }

        return root
    }
}