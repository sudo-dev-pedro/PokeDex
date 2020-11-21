package com.example.pokedex.model

import androidx.annotation.DrawableRes
import com.example.pokedex.R
import com.google.gson.annotations.SerializedName

class PokemonType () {
    companion object{
        fun getDrawableTypeColor(tipo : String?) : Int {
            val cor : Int

            when(tipo){
                "fire" -> cor = R.drawable.bkg_rounded_type_fire
                "dragon" -> cor = R.drawable.bkg_rounded_type_dragon
                "flying" -> cor = R.drawable.bkg_rounded_type_flying
                "ghost" -> cor = R.drawable.bkg_rounded_type_ghost
                "poison" -> cor = R.drawable.bkg_rounded_type_poison
                "grass" -> cor = R.drawable.bkg_rounded_type_grass
                "ground" -> cor = R.drawable.bkg_rounded_type_ground
                "normal" -> cor = R.drawable.bkg_rounded_type_normal
                "psychic" -> cor = R.drawable.bkg_rounded_type_psychic
                "fairy" -> cor = R.drawable.bkg_rounded_type_fairy
                "rock" -> cor = R.drawable.bkg_rounded_type_rock
                "steel" -> cor = R.drawable.bkg_rounded_type_steel
                "water" -> cor = R.drawable.bkg_rounded_type_water
                "dark" -> cor = R.drawable.bkg_rounded_type_dark
                "bug" -> cor = R.drawable.bkg_rounded_type_bug
                "electric" -> cor = R.drawable.bkg_rounded_type_electric
                "fight" -> cor = R.drawable.bkg_rounded_type_fight
                "ice" -> cor = R.drawable.bkg_rounded_type_ice
                else -> cor = R.drawable.bkg_rounded_type_none
            }
            return cor
        }

        fun getThemeByType(tipo : String?) : Int {
            var cor : Int = 0

            when(tipo){
                "fire" -> cor = R.color.fire_color
                "dragon" -> cor = R.color.dragon_color
                "flying" -> cor = R.color.flying_color
                "ghost" -> cor = R.color.ghost_color
                "poison" -> cor = R.color.poison_color
                "grass" -> cor = R.color.grass_color
                "ground" -> cor = R.color.ground_color
                "normal" -> cor = R.color.normal_color
                "psychic" -> cor = R.color.psychic_color
                "fairy" -> cor = R.color.fairy_color
                "rock" -> cor = R.color.rock_color
                "steel" -> cor = R.color.steel_color
                "water" -> cor = R.color.water_color
                "dark" -> cor = R.color.dark_color
                "bug" -> cor = R.color.bug_color
                "electric" -> cor = R.color.electric_color
                "fight" -> cor = R.color.fight_color
                "ice" -> cor = R.color.ice_color
                else -> cor = R.color.white
            }
            return cor
        }

        fun getIconByType(tipo: String?) : Int{
            var icone : Int = 0

            when(tipo){
                "fire" -> icone = R.drawable.ic_fire
                "dragon" -> icone = R.drawable.ic_dragon
                "flying" -> icone = R.drawable.ic_flying
                "ghost" -> icone = R.drawable.ic_ghost
                "poison" -> icone = R.drawable.ic_poison
                "grass" -> icone = R.drawable.ic_grass
                "ground" -> icone = R.drawable.ic_ground
                "normal" -> icone = R.drawable.ic_normal
                "psychic" -> icone = R.drawable.ic_psychic
                "fairy" -> icone = R.drawable.ic_fairy
                "rock" -> icone = R.drawable.ic_rock
                "steel" -> icone = R.drawable.ic_iron
                "water" -> icone = R.drawable.ic_water
                "dark" -> icone = R.drawable.ic_dark
                "bug" -> icone = R.drawable.ic_bug
                "electric" -> icone = R.drawable.ic_electric
                "fight" -> icone = R.drawable.ic_fighting
                "ice" -> icone = R.drawable.ic_ice
                else -> icone = R.drawable.ic_normal
            }
            return icone
        }

        fun getPrimaryIconByType(tipo: String?) : Int{
            var icone : Int = 0

            when(tipo){
                "fire" -> icone = R.drawable.bkg_icon_fire
                "dragon" -> icone = R.drawable.bkg_icon_dragon
                "flying" -> icone = R.drawable.bkg_icon_flying
                "ghost" -> icone = R.drawable.bkg_icon_ghost
                "poison" -> icone = R.drawable.bkg_icon_poison
                "grass" -> icone = R.drawable.bkg_icon_grass
                "ground" -> icone = R.drawable.bkg_icon_ground
                "normal" -> icone = R.drawable.bkg_icon_normal
                "psychic" -> icone = R.drawable.bkg_icon_psychic
                "fairy" -> icone = R.drawable.bkg_icon_fairy
                "rock" -> icone = R.drawable.bkg_icon_rock
                "steel" -> icone = R.drawable.bkg_icon_steel
                "water" -> icone = R.drawable.bkg_icon_water
                "dark" -> icone = R.drawable.bkg_icon_dark
                "bug" -> icone = R.drawable.bkg_icon_bug
                "electric" -> icone = R.drawable.bkg_icon_electric
                "fight" -> icone = R.drawable.bkg_icon_fight
                "ice" -> icone = R.drawable.bkg_icon_ice
                else -> icone = R.drawable.bkg_icon_none
            }
            return icone
        }

        fun setProgressBarByType(tipo: String?) : Int{
            val cor : Int

            when(tipo){
                "fire" -> cor = R.drawable.bkg_custom_progressbar_fire
                "dragon" -> cor = R.drawable.bkg_custom_progressbar_dragon
                "flying" -> cor = R.drawable.bkg_custom_progressbar_flying
                "ghost" -> cor = R.drawable.bkg_custom_progressbar_ghost
                "poison" -> cor = R.drawable.bkg_custom_progressbar_poison
                "grass" -> cor = R.drawable.bkg_custom_progressbar_grass
                "ground" -> cor = R.drawable.bkg_custom_progressbar_ground
                "normal" -> cor = R.drawable.bkg_custom_progressbar_normal
                "psychic" -> cor = R.drawable.bkg_custom_progressbar_psychic
                "fairy" -> cor = R.drawable.bkg_custom_progressbar_fairy
                "rock" -> cor = R.drawable.bkg_custom_progressbar_rock
                "steel" -> cor = R.drawable.bkg_custom_progressbar_steel
                "water" -> cor = R.drawable.bkg_custom_progressbar_water
                "dark" -> cor = R.drawable.bkg_custom_progressbar_dark
                "bug" -> cor = R.drawable.bkg_custom_progressbar_bug
                "electric" -> cor = R.drawable.bkg_custom_progressbar_electric
                "fight" -> cor = R.drawable.bkg_custom_progressbar_fight
                "ice" -> cor = R.drawable.bkg_custom_progressbar_ice

                else -> cor = R.drawable.bkg_custom_progressbar_none
            }

            return cor
        }
    }
}