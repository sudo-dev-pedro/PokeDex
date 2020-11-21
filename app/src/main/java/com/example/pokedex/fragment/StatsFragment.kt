package com.example.pokedex.fragment

import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import com.example.pokedex.R
import com.example.pokedex.adapter.WeaknessAdapter
import com.example.pokedex.utils.PokemonUtils

class StatsFragment : Fragment() {

    private lateinit var valueHP : TextView
    private lateinit var valueATK : TextView
    private lateinit var valueDEF : TextView
    private lateinit var valueSATK : TextView
    private lateinit var valueSDEF : TextView
    private lateinit var valueSPD : TextView
    private lateinit var progressBarHP : ProgressBar
    private lateinit var progressBarATK : ProgressBar
    private lateinit var progressBarDEF : ProgressBar
    private lateinit var progressBarSATK : ProgressBar
    private lateinit var progressBarSDEF : ProgressBar
    private lateinit var progressBarSPD : ProgressBar

    @RequiresApi(Build.VERSION_CODES.N)
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view : View = inflater.inflate(R.layout.fragment_stats, container, false)
        val statsPokemon = arguments?.getIntegerArrayList("Stats")
        val weaknessesPokemon = arguments?.getStringArrayList("Weaknesses")

        val hp = statsPokemon?.get(0)
        progressBarHP = view.findViewById(R.id.prgValueHP)
        valueHP = view.findViewById(R.id.txtValueHP)
        valueHP.text = PokemonUtils.makeValuesMask(hp)
        if (hp != null) {
            progressBarHP = view.findViewById(R.id.prgValueHP)
            progressBarHP.setProgress(hp, true)
        }

        val atk = statsPokemon?.get(1)
        progressBarATK = view.findViewById(R.id.prgValueATK)
        valueATK = view.findViewById(R.id.txtValueATK)
        valueATK.text = PokemonUtils.makeValuesMask(atk)
        if (atk != null) {
            progressBarATK.setProgress(atk, true)
        }

        val def = statsPokemon?.get(2)
        progressBarDEF = view.findViewById(R.id.prgValueDEF)
        valueDEF = view.findViewById(R.id.txtValueDEF)
        valueDEF.text = PokemonUtils.makeValuesMask(def)
        if (def != null) {
            progressBarDEF.setProgress(def, true)
        }


        val satk = statsPokemon?.get(3)
        progressBarSATK = view.findViewById(R.id.prgValueSATK)
        valueSATK = view.findViewById(R.id.txtValueSATK)
        valueSATK.text = PokemonUtils.makeValuesMask(satk)
        if (satk != null) {
            progressBarSATK.setProgress(satk, true)
        }


        val sdef = statsPokemon?.get(4)
        progressBarSDEF = view.findViewById(R.id.prgValueSDEF)
        valueSDEF = view.findViewById(R.id.txtValueSDEF)
        valueSDEF.text = PokemonUtils.makeValuesMask(sdef)
        if (sdef != null) {
            progressBarSDEF.setProgress(sdef, true)
        }

        val spd = statsPokemon?.get(5)
        progressBarSPD = view.findViewById(R.id.prgValueSPD)
        valueSPD = view.findViewById(R.id.txtValueSPD)
        valueSPD.text = PokemonUtils.makeValuesMask(spd)
        if (spd != null) {
            progressBarSPD.setProgress(spd, true)
        }

        weaknessesPokemon?.let {
            WeaknessAdapter(it)
            Log.d("teste", it.toString())
        }

        return view
    }

}