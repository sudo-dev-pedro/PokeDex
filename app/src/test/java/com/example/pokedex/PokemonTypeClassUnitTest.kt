package com.example.pokedex

import com.example.pokedex.model.PokemonType
import junit.framework.TestCase
import junit.framework.TestCase.assertEquals
import org.junit.Before
import org.junit.Test

class PokemonTypeClassUnitTest {
    private lateinit var pokemonType : PokemonType

    @Test
    fun shouldReturnIntDrawableForIcon(){
        val result = PokemonType.getDrawableTypeColor("grass")
        assertEquals(2131165329, result)
    }
}