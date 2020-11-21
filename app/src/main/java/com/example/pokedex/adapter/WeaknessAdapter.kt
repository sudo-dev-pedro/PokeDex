package com.example.pokedex.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.pokedex.R
import com.example.pokedex.model.PokemonType
import com.example.pokedex.utils.PokemonUtils

class WeaknessAdapter (
        private val weaknesses : ArrayList<String>
) : RecyclerView.Adapter<WeaknessAdapter.WeaknessViewHolder>() {

    class WeaknessViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){
        val iconeFraqueza : ImageView = itemView.findViewById(R.id.imgIconWeakness)
        val nomeFraqueza : TextView = itemView.findViewById(R.id.txtTitleWeakness)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ) : WeaknessViewHolder {
        val item = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.pokemon_weakness, parent, false)

        return WeaknessViewHolder(item)
    }

    override fun onBindViewHolder(holder: WeaknessViewHolder, position: Int) {
        Log.d("Teste", weaknesses.get(position).toString())
        holder.itemView.apply {
            holder.iconeFraqueza.setBackgroundResource(PokemonType.getPrimaryIconByType(weaknesses.get(position)))
            holder.nomeFraqueza.text = (weaknesses.get(position))
        }
    }

    override fun getItemCount(): Int {
        return weaknesses.size
    }
}