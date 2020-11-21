package com.example.pokedex.utils

class PokemonUtils {

    companion object {
        fun capitalizeFirstLetterOfPokemon(string : String?) : String? = string?.capitalize()

        fun makeIDMask(id : Int) : String {
            val charBefore = "#"
            var masked = ""

            masked = when(id){
                in 0..9 -> charBefore + "00" + "$id"
                in 10..99 -> charBefore + "0" + "$id"
                in 100..900 -> charBefore + "$id"
                else -> "$id"
            }

            return masked
        }

        fun makeValuesMask(value : Int?) : String {
            val charBefore = "0"
            var masked = ""

            value?.let{
                masked = when(value){
                    in 0..99 -> charBefore + "$value"
                    else -> "$value"
                }
            }
            return masked
        }

        fun prepareImages(id : Int) : String {
            return "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/${id}.png"
        }

    }
}