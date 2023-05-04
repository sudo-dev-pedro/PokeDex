package com.example.pokedex.service

import com.example.pokedex.network.response.PokemonListResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface PokeService {
    @GET("pokemon")
    suspend fun getPokemonList(
        @Query("limit") limit: Int,
        @Query("offset") offset: Int
    ): PokemonListResponse
}