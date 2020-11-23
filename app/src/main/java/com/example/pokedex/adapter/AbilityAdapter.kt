package com.example.pokedex.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.pokedex.R
import com.example.pokedex.model.PokemonAbilities
import com.example.pokedex.utils.PokemonUtils

class AbilityAdapter (
        private val abilities : ArrayList<PokemonAbilities>
) : RecyclerView.Adapter<AbilityAdapter.AbilityViewHolder>() {

    class AbilityViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){
        val tituloHabilidade : TextView = itemView.findViewById(R.id.txtViewAbilityTitle)
        val descricaoHabilidade : TextView = itemView.findViewById(R.id.txtViewDesciptionAbility)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): AbilityViewHolder {
        val item = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.pokemon_abilities, parent, false)

        return AbilityViewHolder(item)
    }

    override fun onBindViewHolder(holder: AbilityAdapter.AbilityViewHolder, position: Int) {
        holder.apply {
            holder.tituloHabilidade.text = PokemonUtils.capitalizeFirstLetterOfPokemon(abilities[position].tituloHabilidade)
            holder.descricaoHabilidade.text = abilities[position].descricaoHabilidade
        }
    }

    override fun getItemCount(): Int {
        return abilities.size
    }
}