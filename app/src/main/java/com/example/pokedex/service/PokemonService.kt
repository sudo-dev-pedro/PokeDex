package com.example.pokedex.service

import com.example.pokedex.model.Pokemon
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.Call

interface PokemonService {
    @GET("pokemon/{id}")
    fun getPokemonData(@Path("id") id : Int) : Call<Pokemon>
}