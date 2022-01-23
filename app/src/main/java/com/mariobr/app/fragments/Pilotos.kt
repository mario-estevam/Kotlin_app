package com.mariobr.app.fragments

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.navigation.ui.NavigationUI
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.room.Room
import com.google.android.material.snackbar.Snackbar
import com.mariobr.app.R
import com.mariobr.app.adapters.NovoPilotoAdapter
import com.mariobr.app.adapters.NovoRecyclerViewClickListener
import com.mariobr.app.databinding.FragmentPilotosBinding
import com.mariobr.app.pilotos.AppDatabase
import com.mariobr.app.pilotos.Piloto


@SuppressLint("UseRequireInsteadOfGet")
class Pilotos : Fragment() {
    lateinit var binding:FragmentPilotosBinding

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
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_pilotos, container, false)
        val adapter  = NovoPilotoAdapter()
        val listaPilotos:MutableList<Piloto> = db.pilotoDao().listAllAdapter()
        adapter.pilotos = listaPilotos
        binding.recyclerview.adapter = adapter
        val layout = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        binding.recyclerview.layoutManager = layout
        binding.recyclerview.addOnItemTouchListener(NovoRecyclerViewClickListener(context!!,binding.recyclerview, object : NovoRecyclerViewClickListener.onItemClickListener{
            override fun onItemClick(v: View, position: Int) {
                Navigation.findNavController(v).navigate(PilotosDirections.actionPilotosToListById(position))
            }
            override fun onItemLongClick(v: View, position: Int) {
                val removida = listaPilotos[position]
                listaPilotos.remove(removida)
                db.pilotoDao().delete(removida)
                binding.recyclerview.adapter!!.notifyItemRemoved(position)
                val snack = Snackbar.make(
                    binding.recyclerview.parent as View,"Removido",Snackbar.LENGTH_LONG )
                    .setAction("Cancelar") {
                       listaPilotos.add(position, removida)
                        binding.recyclerview.adapter!!.notifyItemInserted(position)
                    }
                snack.show()
            }
        }))
        setHasOptionsMenu(true)
        return binding.root
    }



}