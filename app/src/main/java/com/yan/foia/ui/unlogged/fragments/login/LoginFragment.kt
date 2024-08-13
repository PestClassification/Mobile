package com.yan.foia.ui.unlogged.fragments.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ToggleButton
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.yan.foia.databinding.FragmentLoginBinding

class LoginFragment : Fragment() {

    private lateinit var backButton: ImageButton
    private lateinit var eyeButton: ToggleButton
    private lateinit var eyeButtonClick: ConstraintLayout
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

        eyeButton = binding.eyeButton
        eyeButtonClick = binding.eyeButtonClick
        eyeButtonClick.setOnClickListener { _ ->
            eyeButton.isChecked = !eyeButton.isChecked
        }

        return root
    }
}