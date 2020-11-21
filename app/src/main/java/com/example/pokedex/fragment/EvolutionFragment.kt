package com.example.pokedex.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.pokedex.R
import com.example.pokedex.adapter.EvolutionAdapter
import com.example.pokedex.model.PokemonEvolutions

class EvolutionFragment : Fragment() {

    private lateinit var recyclerView : RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view : View = inflater.inflate(R.layout.fragment_evolutions, container, false)
        recyclerView = view.findViewById(R.id.rvEvolutions)

        initAdapterEvolutions()
        createEvolutionsList()
        manageRecyclerViewEvolutions()

        return view
    }

    private fun initAdapterEvolutions(){
        recyclerView.adapter = EvolutionAdapter(
            createEvolutionsList()
        )
    }

    private fun createEvolutionsList() : MutableList<PokemonEvolutions>{
        var evolutions = mutableListOf<PokemonEvolutions>()
        evolutions.add(PokemonEvolutions("Forma Original", "Forma 2"))
        evolutions.add(PokemonEvolutions("Forma 2", "Forma 3"))
        return evolutions
    }

    private fun manageRecyclerViewEvolutions(){
        recyclerView.layoutManager = LinearLayoutManager(
            activity,
            LinearLayoutManager.VERTICAL,
            false
        )
    }
}



