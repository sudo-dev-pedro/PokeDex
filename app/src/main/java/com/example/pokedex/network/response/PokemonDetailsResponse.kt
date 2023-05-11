package com.example.pokedex.network.response

data class PokemonDetailsResponse(
    val type: String,
    val stats: ArrayList<Int>
)