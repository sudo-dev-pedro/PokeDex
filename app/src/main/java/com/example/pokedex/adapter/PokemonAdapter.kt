package com.example.pokedex.adapter

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
import com.example.pokedex.utils.PokemonUtils

class PokemonAdapter(
    private val pokemonList: List<Pokemon>,
    private val onCellClickListener: CellPokemonClickListener,
) : RecyclerView.Adapter<PokemonAdapter.PokemonViewHolder>() {

    class PokemonViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val pokemonId: TextView = itemView.findViewById(R.id.txtPokemonID)
        val pokemonName: TextView = itemView.findViewById(R.id.txtPokemonName)
        val pokemonImage: ImageView = itemView.findViewById(R.id.imgPokemon)
        val iconeTipoPrimario: ImageView = itemView.findViewById(R.id.txtViewIconPrimary)
        var iconeTipoSecundario: ImageView = itemView.findViewById(R.id.txtViewIconSecondary)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PokemonViewHolder {
        val item = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.pokemon_item, parent, false)

        return PokemonViewHolder(item)
    }

    override fun onBindViewHolder(holder: PokemonViewHolder, position: Int) {
        holder.itemView.apply {
            Glide
                .with(holder.itemView.context)
                .load(getPokemonImage(pokemonList[position].url))
                .into(holder.pokemonImage)
            holder.pokemonId.text =
                PokemonUtils.makeIDMask(
                    PokemonUtils.getPokemonIDFromURL(pokemonList[position].url)
                )
            holder.pokemonName.text = PokemonUtils.capitalizeFirstLetterOfPokemon(
                pokemonList[position].name
            )
//            holder.iconeTipoPrimario.setBackgroundResource(
//                    PokemonType.getPrimaryIconByType(
//                            pokemons[position].tipos.get(0).type.name
//                    )
//            )

//            if(pokemons[position].tipos.size == 2) {
//                holder.iconeTipoSecundario.setBackgroundResource(
//                        PokemonType.getPrimaryIconByType(
//                                pokemons[position].tipos.get(1).type.name
//                        )
//                )
//            }

            holder.itemView.setOnClickListener {
                onCellClickListener.onPokemonCellClickListener(pokemonList[position])
            }
        }
    }

    override fun getItemCount(): Int {
        return pokemonList.size
    }

    private fun getPokemonImage(url: String): String {
        Log.d("PEDRO", url)
        val pokemonID = PokemonUtils.getPokemonIDFromURL(url)
        Log.d("PEDRO", pokemonID.toString())
        Log.d("PEDRO", "$BASE_URL_IMAGE${pokemonID}$IMAGE_EXTENSION")
        return "$BASE_URL_IMAGE${pokemonID}$IMAGE_EXTENSION"
    }

    companion object {
        const val BASE_URL_IMAGE =
            "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/"
        const val IMAGE_EXTENSION = ".png"
    }
}