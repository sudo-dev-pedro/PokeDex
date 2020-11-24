package com.example.pokedex

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.pokedex.`interface`.CellPokemonClickListener
import com.example.pokedex.adapter.PokemonAdapter
import com.example.pokedex.model.Pokemon
import kotlinx.coroutines.*
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.Dispatchers.Main
import me.sargunvohra.lib.pokekotlin.client.PokeApiClient

class PokemonListActivity : AppCompatActivity(), CellPokemonClickListener{
    private lateinit var loadingGif : ImageView
    private lateinit var intentItem : Intent
    private lateinit var pokemons : MutableList<Pokemon>
    private lateinit var pokemonApi: PokeApiClient
    private lateinit var recyclerViewPokemons : RecyclerView
    private lateinit var loadingText : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_poke_list)

        initViews()
        callLoading()

        CoroutineScope(IO).launch {
            requestPokemonApi()
        }
    }

    private suspend fun passDataToUI(pokemonList: MutableList<Pokemon>){
        withContext(Main) {
            delay(5000)
            initAdapter(pokemonList)
            manageRecyclerView()
            setViewsVisibility()
        }
    }

    private suspend fun requestPokemonApi(){
        val result = getPokemonList()
        passDataToUI(result)
    }

    private suspend fun getPokemonList() : MutableList<Pokemon> {
        delay(1000)

        pokemons = mutableListOf()
        pokemonApi = PokeApiClient()

        /*
        var i = 0

        do {
            val pokemonData = pokemonApi.getPokemon(++i)
            val pokemonID = pokemonData.id
            val pokemonName = pokemonData.name
            val pokemonTipoPrimario = pokemonData.types[0].type.name
            val pokemonTipos = pokemonData.types
            pokemons.add(Pokemon(pokemonID, pokemonName, pokemonTipoPrimario, pokemonTipos))
            Log.d("Teste", i.toString())
        }while (pokemonData != null)
        */

        //Limitado para testes
        for (i in 1..10) {
            var pokemonData = pokemonApi.getPokemon(i)
            val pokemonID = pokemonData.id
            val pokemonName = pokemonData.name
            val pokemonTipoPrimario = pokemonData.types[0].type.name
            val pokemonTipos = pokemonData.types
            pokemons.add(Pokemon(pokemonID, pokemonName, pokemonTipoPrimario, pokemonTipos))
        }

        return pokemons
    }

    private fun initViews(){
        this.recyclerViewPokemons = findViewById(R.id.rvPokemonList)
        this.loadingGif = findViewById(R.id.gifLoadingList)
        this.loadingText = findViewById(R.id.txtLoading)
    }

    private fun callLoading(){
        this.loadingGif.visibility = View.VISIBLE
        this.loadingText.visibility = View.VISIBLE
        Glide
            .with(this)
            .asGif()
            .load(R.raw.loading_list)
            .into(loadingGif)
    }

    private fun initAdapter(pokemonList : MutableList<Pokemon>){
        this.recyclerViewPokemons.adapter = PokemonAdapter(
                pokemonList,
                this,
                this)
    }

    private fun manageRecyclerView(){
        this.recyclerViewPokemons.layoutManager = LinearLayoutManager(
                this,
                LinearLayoutManager.VERTICAL,
                false)
        this.recyclerViewPokemons.setHasFixedSize(true)
    }

    private fun setViewsVisibility(){
        this.loadingGif.visibility = View.GONE
        this.loadingText.visibility = View.GONE
    }

    override fun onPokemonCellClickListener(data: Pokemon) {

        this.intentItem = Intent(
                this,
                PokemonDetailActivity::class.java).apply {
                    putExtra("id", data.id.toString())
                    putExtra("nome", data.nome)
                    putExtra("tipoPrimario", data.tipoPrimario)
                }

        startActivity(intentItem)
    }
}