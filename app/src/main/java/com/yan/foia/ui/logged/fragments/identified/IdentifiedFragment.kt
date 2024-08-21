package com.yan.foia.ui.logged.fragments.identified

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.skydoves.expandablelayout.ExpandableLayout
import com.yan.foia.R
import com.yan.foia.databinding.FragmentIdentifiedBinding

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

        val ex = view?.findViewById<ExpandableLayout>(R.id.description_expand) //recupera o id
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

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val desc = view.findViewById<ExpandableLayout>(R.id.description_expand) //recupera o id
        val rec = view.findViewById<ExpandableLayout>(R.id.recommend_expand) //recupera o id
        //expandable de "produto", ainda nao adicionado:
        //val prod = view.findViewById<ExpandableLayout>(R.id.description_expand) //recupera o id

        //variáveis de controle da abertura dos 3 expandable layouts
        var g1 = 0
        var g2 = 0
        //var g3 = 0
        //duvida no comportamento e implicações do operador non-nullable: '?.'
        desc?.parentLayout?.setOnClickListener{
            if (g1==0){
                g1 = 1
                desc.expand()
                if (g2==1){
                    g2 = 0
                    rec.collapse()}
                //if (g3==1){prod.collapse()}
            }
            else{
                g1 = 0
                desc.collapse()
            }

    }
        rec?.parentLayout?.setOnClickListener{
            if (g2==0){
                g2 = 1
                rec.expand()
                if (g1==1){desc.collapse()}
                //if (g3==1){prod.collapse()}
            }
            else{
                g2 = 0
                rec.collapse()
            }

        }

}}