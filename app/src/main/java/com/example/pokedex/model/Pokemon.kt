package com.example.pokedex.model

import me.sargunvohra.lib.pokekotlin.model.PokemonType
import java.io.Serializable

class Pokemon(
        val id: Int,
        val nome: String,
        val tipoPrimario: String,
        val tipos: List<PokemonType>
)