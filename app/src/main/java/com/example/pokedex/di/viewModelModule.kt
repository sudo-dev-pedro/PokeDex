package com.example.pokedex.di

import com.example.pokedex.ui.pokemondetail.viewmodel.PokemonDetailsViewModel
import com.example.pokedex.ui.pokemonlist.viewmodel.PokemonListViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel {
        PokemonListViewModel(get())
    }

    viewModel {
        PokemonDetailsViewModel(get())
    }
}