package com.example.pokedex.network.response

import com.example.pokedex.model.Pokemon

data class PokemonListResponse(
    val results: List<Pokemon>
)
