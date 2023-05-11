package com.example.pokedex.ui.pokemondetail.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.pokedex.service.PokeService

class PokemonDetailsViewModel(
    private val pokemonService: PokeService
) : ViewModel() {

    private val _pokemonStats = MutableLiveData<ArrayList<Int>>()
    val pokemonStats: LiveData<ArrayList<Int>>
        get() = _pokemonStats

    private val _pokemonAbilities = MutableLiveData<ArrayList<String>>()
    val pokemonAbilities: LiveData<ArrayList<String>>
        get() = _pokemonAbilities

    fun getPokemonDetails(name: String) {

    }
}