package com.mariobr.app.fragments

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.navigation.ui.NavigationUI
import androidx.room.Room
import com.mariobr.app.R
import com.mariobr.app.databinding.FragmentCadastroBinding
import com.mariobr.app.pilotos.AppDatabase
import com.mariobr.app.pilotos.Piloto


@SuppressLint("UseRequireInsteadOfGet")
class Cadastro : Fragment() {

    lateinit var binding:FragmentCadastroBinding

    val db: AppDatabase by lazy{
        Room.databaseBuilder(
            context!!,
            AppDatabase::class.java, "database-name")
            .allowMainThreadQueries()
            .build()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_cadastro, container, false)
        binding.salvar.setOnClickListener{
            var nome = binding.editTextNome.text.toString()
            var categoria = binding.editTextCategoria.text.toString()
            var cidade = binding.editTextCidade.text.toString()
            var numero = binding.editTextNumero.text.toString().toInt()
            db.pilotoDao().inserir(Piloto(nome, categoria, cidade, numero))
            Navigation.findNavController(it).navigate(R.id.action_cadastro_to_telaInicial)
        }
        setHasOptionsMenu(true)
        return binding.root
    }





}