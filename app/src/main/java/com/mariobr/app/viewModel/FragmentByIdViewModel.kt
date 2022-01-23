package com.mariobr.app.viewModel

import androidx.lifecycle.ViewModel
import com.mariobr.app.fragments.bindingList
import com.mariobr.app.pilotos.Piloto



class FragmentByIdViewModel: ViewModel() {

    var x = 0;
    lateinit var array:Array<Piloto>
    var nome:String = ""
    var categoria:String = ""
    var cidade:String = ""
    var numero:String = ""

    fun setAttributes(){
        bindingList.textViewNome.text = array[x].nome
        bindingList.textViewCategoria.text = array[x].categoria
        bindingList.textViewCidade.text = array[x].cidade
        bindingList.textViewNumero.text =  array[x].numero.toString()
        nome = array[x].nome
        categoria = array[x].categoria
        cidade = array[x].cidade
        numero = array[x].numero.toString()

    }



}