package com.example.pokedex

import com.example.pokedex.model.PokemonType
import junit.framework.TestCase.assertEquals
import org.junit.Before
import org.junit.Test

class PokemonTypeClassUnitTest {
    private lateinit var pokemonType : PokemonType

    @Test
    fun shouldReturnIntDrawableForIcon(){
        TODO()
    }

    @Before
    fun createPokemonType(){
        pokemonType = PokemonType()
    }
}