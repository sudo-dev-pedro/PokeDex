package com.example.pokedex.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.pokedex.R
import com.example.pokedex.model.PokemonEvolutions

class EvolutionAdapter (
    private val pokemonEvolutions : List<PokemonEvolutions>
) : RecyclerView.Adapter<EvolutionAdapter.EvolutionViewHolder>() {

    class EvolutionViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {
        val nomePrimeiraEvolucao : TextView = itemView.findViewById(R.id.txtViewForm1Name)
        //val imagemPrimeiraEvolucao : ImageView = itemView.findViewById(R.id.imgViewForm1)
        val nomeSegundaEvolucao : TextView = itemView.findViewById(R.id.txtViewForm2Name)
        //val imagemSegundaEvolucao : ImageView = itemView.findViewById(R.id.imgViewForm2)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): EvolutionViewHolder {
        val item = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.pokemon_evolution, parent, false)

        return EvolutionViewHolder(item)
    }

    override fun onBindViewHolder(holder: EvolutionAdapter.EvolutionViewHolder, position: Int) {
        holder.apply {
            holder.nomePrimeiraEvolucao.text = pokemonEvolutions[position].nomePrimeiraEvolucao
            //holder.imagemPrimeiraEvolucao.setImageResource(pokemonEvolutions[position].imagemPrimeiraEvolucao)
            holder.nomeSegundaEvolucao.text = pokemonEvolutions[position].nomeSegundaEvolucao
            //holder.imagemSegundaEvolucao.setImageResource(pokemonEvolutions[position].imagemSegundaEvolucao)
        }
    }

    override fun getItemCount(): Int {
        return pokemonEvolutions.size
    }
}