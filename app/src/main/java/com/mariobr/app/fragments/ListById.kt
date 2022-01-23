package com.mariobr.app.fragments

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.navigation.fragment.navArgs
import androidx.room.Room
import com.mariobr.app.R
import com.mariobr.app.databinding.FragmentListByIdBinding
import com.mariobr.app.pilotos.AppDatabase
import com.mariobr.app.pilotos.Piloto
import com.mariobr.app.viewModel.FragmentByIdViewModel

lateinit var bindingList:FragmentListByIdBinding

@SuppressLint("UseRequireInsteadOfGet")
class ListById : Fragment() {

    val db: AppDatabase by lazy{
        Room.databaseBuilder(
            context!!,
            AppDatabase::class.java, "database-name")
            .allowMainThreadQueries()
            .build()
    }

    lateinit var viewModel: FragmentByIdViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        bindingList= DataBindingUtil.inflate(inflater, R.layout.fragment_list_by_id, container, false)
        viewModel = ViewModelProvider(this,).get(FragmentByIdViewModel::class.java)
        val args: ListByIdArgs by navArgs()
        viewModel.x = args.id
        viewModel.array = db.pilotoDao().listAll()
        viewModel.setAttributes()
        val result = viewModel.array.map { it.nome }
        val pilotoToListAdapter = ArrayAdapter<String>(context!!, android.R.layout.simple_expandable_list_item_1,result)
        bindingList.autoComplete.setAdapter(pilotoToListAdapter)
        bindingList.autoComplete.setOnItemClickListener(){ adapterView, view, i, l ->
            var selected = adapterView.getItemAtPosition(i)
            for(j in  viewModel.array.indices){
                if( viewModel.array[j].nome == selected.toString()){
                    bindingList.textViewNome.text = viewModel.array[j].nome
                    bindingList.textViewCategoria.text = viewModel.array[j].categoria
                    bindingList.textViewCidade.text = viewModel.array[j].cidade
                    bindingList.textViewNumero.text =  viewModel.array[j].numero.toString()
                }
            }
        }

        setHasOptionsMenu(true)
        return bindingList.root
    }
}