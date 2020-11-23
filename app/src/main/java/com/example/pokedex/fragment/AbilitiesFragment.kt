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
import com.example.pokedex.adapter.AbilityAdapter
import com.example.pokedex.model.PokemonAbilities

class AbilitiesFragment : Fragment() {

    private lateinit var recyclerView : RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var view : View = inflater.inflate(R.layout.fragment_abilities, container, false)
        val abilitiesPokemon = arguments?.getParcelableArrayList<PokemonAbilities>("Abilities")

        recyclerView = view.findViewById(R.id.rvAbilities)

        abilitiesPokemon?.let {
            initAdapterAbilities(it)
            manageRecyclerViewAbilities()
        }

        return view
    }

    private fun initAdapterAbilities(abilities : ArrayList<PokemonAbilities>){
        recyclerView.adapter = AbilityAdapter(
            abilities
        )
    }

    private fun manageRecyclerViewAbilities(){
        recyclerView.layoutManager = LinearLayoutManager(
            activity,
            LinearLayoutManager.VERTICAL,
            false
        )
    }
}