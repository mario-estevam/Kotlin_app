package com.mariobr.app.fragments

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.navigation.ui.NavigationUI
import com.mariobr.app.R
import com.mariobr.app.databinding.FragmentTelaInicialBinding

class TelaInicial : Fragment() {
    lateinit var binding:FragmentTelaInicialBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_tela_inicial, container, false)
        binding.button.setOnClickListener{
            Navigation.findNavController(it).navigate(R.id.action_telaInicial_to_pilotos)
        }
        setHasOptionsMenu(true)
        return binding.root
    }



}