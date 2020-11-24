package com.example.pokedex.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.pokedex.R
import com.example.pokedex.adapter.EvolutionAdapter
import com.example.pokedex.model.PokemonAbilities
import com.example.pokedex.model.PokemonEvolutions

class EvolutionFragment : Fragment() {

    private lateinit var recyclerView : RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view : View = inflater.inflate(R.layout.fragment_evolutions, container, false)
        val evolutionsPokemon = arguments?.getParcelableArrayList<PokemonEvolutions>("Evolutions")

        recyclerView = view.findViewById(R.id.rvEvolutions)

        evolutionsPokemon?.let {
            initAdapterEvolutions(it)
            manageRecyclerViewEvolutions()
        }

        return view
    }

    private fun initAdapterEvolutions(evolutions : ArrayList<PokemonEvolutions>){
        recyclerView.adapter = EvolutionAdapter(
            evolutions
        )
    }

    private fun manageRecyclerViewEvolutions(){
        recyclerView.layoutManager = LinearLayoutManager(
            activity,
            LinearLayoutManager.VERTICAL,
            false
        )
    }
}



