package com.yan.foia.ui.logged.fragments.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.yan.foia.databinding.FragmentHomeBinding
import com.yan.foia.databinding.FragmentIdentifiedBinding

class HomeFragment : Fragment() {
    private var _binding: FragmentHomeBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

//        val welcomeViewModel = ViewModelProvider(this)[WelcomeViewModel::class.java]

        _binding = FragmentHomeBinding.inflate(layoutInflater, container, false)
        val root: View = binding.root

        return root
    }
}