package com.mariobr.app.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.mariobr.app.R
import com.mariobr.app.pilotos.Piloto

class NovoPilotoAdapter : RecyclerView.Adapter<NovoPilotoViewHolder>() {

    var pilotos:List<Piloto> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NovoPilotoViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.piloto_inflater, parent, false)
        val holder = NovoPilotoViewHolder(v)
        return holder
    }

    override fun onBindViewHolder(holder: NovoPilotoViewHolder, position: Int) {
        val pilotoEscolhido = pilotos.get(position)

        holder.numero.text = pilotoEscolhido.numero.toString()
        holder.nomePiloto.text = pilotoEscolhido.nome
        holder.categoriaPiloto.text = pilotoEscolhido.categoria

    }

    override fun getItemCount(): Int {
        return pilotos.size
    }


}


class NovoPilotoViewHolder(v: View) : RecyclerView.ViewHolder(v){
    val numero = v.findViewById<TextView>(R.id.numeroPiloto)
    val nomePiloto = v.findViewById<TextView>(R.id.nomePiloto)
    val categoriaPiloto = v.findViewById<TextView>(R.id.categoriaPiloto)

}