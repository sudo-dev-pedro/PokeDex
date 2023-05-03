package com.example.pokedex.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.pokedex.R
import com.example.pokedex.model.PokemonEvolutions

class EvolutionAdapter(
    private val pokemonEvolutions: List<PokemonEvolutions>
) : RecyclerView.Adapter<EvolutionAdapter.EvolutionViewHolder>() {

    class EvolutionViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val firstEvolution: TextView = itemView.findViewById(R.id.txtViewForm1Name)

        //val imagemPrimeiraEvolucao : ImageView = itemView.findViewById(R.id.imgViewForm1)
        val secondEvolution: TextView = itemView.findViewById(R.id.txtViewForm2Name)
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
            holder.firstEvolution.text = pokemonEvolutions[position].evolutions
            //holder.imagemPrimeiraEvolucao.setImageResource(pokemonEvolutions[position].imagemPrimeiraEvolucao)
            holder.secondEvolution.text = pokemonEvolutions[position].secondEvolution
            //holder.imagemSegundaEvolucao.setImageResource(pokemonEvolutions[position].imagemSegundaEvolucao)
        }
    }

    override fun getItemCount(): Int {
        return pokemonEvolutions.size
    }
}