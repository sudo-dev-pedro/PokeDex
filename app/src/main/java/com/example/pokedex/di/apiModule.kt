package com.example.pokedex.di

import com.example.pokedex.network.api.PokeApi
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val apiModule = module {
    single {
        PokeApi(androidContext()).getPokemonService()
    }
}
