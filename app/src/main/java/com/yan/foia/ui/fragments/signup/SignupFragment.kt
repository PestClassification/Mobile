package com.yan.foia.ui.fragments.signup

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageButton
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.yan.foia.databinding.FragmentSignupBinding

class SignupFragment : Fragment() {

    private lateinit var backButton: ImageButton
    private lateinit var eyeButton: ImageButton
    private lateinit var eyeButtonConfirm: ImageButton
    private lateinit var signupButton: Button
    private var _binding: FragmentSignupBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        val signupViewModel = ViewModelProvider(this)[SignupViewModel::class.java]

        _binding = FragmentSignupBinding.inflate(layoutInflater, container, false)
        val root : View = binding.root

        backButton = binding.loginBackButton
        backButton.setOnClickListener { _ ->
            parentFragmentManager.popBackStack()
        }

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}