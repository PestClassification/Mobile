package com.yan.foia.ui.logged.fragments.identified

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.viewbinding.ViewBindings
import com.skydoves.expandablelayout.ExpandableLayout
import com.yan.foia.R
import com.yan.foia.databinding.FragmentIdentifiedBinding
import com.yan.foia.ui.unlogged.fragments.welcome.WelcomeViewModel

class IdentifiedFragment : Fragment() {
    private var _binding: FragmentIdentifiedBinding? = null

    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

//        val welcomeViewModel = ViewModelProvider(this)[WelcomeViewModel::class.java]

        _binding = FragmentIdentifiedBinding.inflate(layoutInflater, container, false)
        val root: View = binding.root

        val ex = view?.findViewById<ExpandableLayout>(R.id.expandable) //recupera o id
        var g = 0
        //duvida no comportamento e implicações do operador non-nullable: '?.'
        ex?.parentLayout?.setOnClickListener{
            if (g==0){
                g = 1
                ex.expand()
            }
            else{
                g = 0
                ex.collapse()
            }
        }

        return root
    }

}