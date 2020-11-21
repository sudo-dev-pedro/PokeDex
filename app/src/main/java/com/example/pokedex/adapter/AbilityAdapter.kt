package com.example.pokedex.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.pokedex.R
import com.example.pokedex.model.PokemonAbilities

class AbilityAdapter (
    private val pokemonAbilities : List<PokemonAbilities>
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
            holder.tituloHabilidade.text = pokemonAbilities[position].tituloHabilidade
            holder.descricaoHabilidade.text = pokemonAbilities[position].descricaoHabilidade
        }
    }

    override fun getItemCount(): Int {
        return pokemonAbilities.size
    }

}