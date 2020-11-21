package com.example.pokedex.adapter

import android.content.Context
import android.media.Image
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.pokedex.R
import com.example.pokedex.`interface`.CellPokemonClickListener
import com.example.pokedex.model.Pokemon
import com.example.pokedex.model.PokemonType
import com.example.pokedex.utils.PokemonUtils

class PokemonAdapter(
        private val pokemons : List<Pokemon>,
        private val context : Context,
        private val onCellClickListener : CellPokemonClickListener
    ) : RecyclerView.Adapter<PokemonAdapter.PokemonViewHolder>() {

    class PokemonViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){
        val idPokemon : TextView = itemView.findViewById(R.id.txtPokemonID)
        val nomePokemon : TextView = itemView.findViewById(R.id.txtPokemonName)
        val imagemPokemon : ImageView = itemView.findViewById(R.id.imgPokemon)
        val iconeTipoPrimario : ImageView = itemView.findViewById(R.id.txtViewIconPrimary)
        var iconeTipoSecundario : ImageView = itemView.findViewById(R.id.txtViewIconSecondary)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PokemonViewHolder {
        val item = LayoutInflater
                .from(parent.context)
                .inflate(R.layout.pokemon_item, parent, false)

        return PokemonViewHolder(item)
    }

    override fun onBindViewHolder(holder: PokemonViewHolder, position: Int) {
        holder.itemView.apply{
            Glide
                .with(holder.itemView.context)
                .load(PokemonUtils.prepareImages(pokemons[position].id))
                .into(holder.imagemPokemon)
            holder.idPokemon.text = PokemonUtils.makeIDMask(pokemons[position].id)
            holder.nomePokemon.text = PokemonUtils.capitalizeFirstLetterOfPokemon(
                    pokemons[position].nome
            )
            holder.iconeTipoPrimario.setBackgroundResource(
                    PokemonType.getPrimaryIconByType(
                            pokemons[position].tipoPrimario
                    )
            )

            if(pokemons[position].tipos.size == 2) {
                holder.iconeTipoSecundario.setBackgroundResource(
                        PokemonType.getPrimaryIconByType(
                                pokemons[position].tipos.get(1).type.name
                        )
                )
            }

            holder.itemView.setOnClickListener{
                onCellClickListener.onPokemonCellClickListener(pokemons[position])
            }
        }
    }

    override fun getItemCount(): Int {
        return pokemons.size
    }
}