package com.yan.foia.ui.fragments.welcome

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.yan.foia.R
import com.yan.foia.databinding.FragmentWelcomeBinding
import com.yan.foia.ui.fragments.login.LoginFragment
import com.yan.foia.ui.fragments.signup.SignupFragment

class WelcomeFragment : Fragment() {

    private lateinit var signupButton: Button
    private lateinit var loginButton: Button
    private var _binding: FragmentWelcomeBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        val welcomeViewModel = ViewModelProvider(this)[WelcomeViewModel::class.java]

        _binding = FragmentWelcomeBinding.inflate(layoutInflater, container, false)
        val root : View = binding.root

        signupButton = binding.welcomeSignupButton
        signupButton.setOnClickListener { _ ->
            parentFragmentManager.beginTransaction()
                .setCustomAnimations(
                    R.anim.slide_in,
                    R.anim.fade_out,
                    R.anim.fade_in,
                    R.anim.slide_out
                )
                .replace(R.id.unlogged_fragment_container, SignupFragment(), null)
                .addToBackStack(null)
                .commit()
        }

        loginButton = binding.welcomeLoginButton
        loginButton.setOnClickListener { _ ->
            parentFragmentManager.beginTransaction()
                .setCustomAnimations(
                    R.anim.slide_in,
                    R.anim.fade_out,
                    R.anim.fade_in,
                    R.anim.slide_out
                )
                .replace(R.id.unlogged_fragment_container, LoginFragment(), null)
                .addToBackStack(null)
                .commit()

//            ObjectAnimator.ofFloat(binding.logoUnlogged, "translationY", 100f).apply {
//                duration = 200
//                start()
//            } // MELHOR FAZER COM O COMPOSE DEPOIS, ANIMAR A LOGO PRA ELA SE MOVER ENTRE A MUDANÇA DE TELA

        }

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}