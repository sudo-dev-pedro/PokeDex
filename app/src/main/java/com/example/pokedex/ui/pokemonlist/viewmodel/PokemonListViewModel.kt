package com.example.pokedex.ui.pokemonlist.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pokedex.model.Pokemon
import com.example.pokedex.service.PokeService
import kotlinx.coroutines.launch

class PokemonListViewModel(
    private val pokemonService: PokeService,
) : ViewModel() {

    private val _pokemonList = MutableLiveData<List<Pokemon>>()
    val pokemonList: LiveData<List<Pokemon>> = _pokemonList

    init {
        viewModelScope.launch {
            val pokemonList = pokemonService.getPokemonList(20, 0)

            _pokemonList.value = pokemonList.results
        }
    }
}