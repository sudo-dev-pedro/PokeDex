package com.example.pokedex

import com.example.pokedex.model.PokemonType
import com.example.pokedex.utils.PokemonUtils
import junit.framework.TestCase
import org.junit.Before
import org.junit.Test

class PokemonUtilsUnitTest {

    @Test
    fun shouldReturnTheImageURL(){
        val result = PokemonUtils.prepareImages(1)
        TestCase.assertEquals("https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/1.png", result)
    }

    @Test
    fun shouldReturnValueMasked(){
        val result = PokemonUtils.makeValuesMask(45)
        TestCase.assertEquals("045", result)
    }

    @Test
    fun shouldReturnIDMasked(){
        val result = PokemonUtils.makeIDMask(100)
        TestCase.assertEquals("#100", result)
    }

}