package com.example.pokedex.ui.pokemonlist.view

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.pokedex.R
import com.example.pokedex.adapter.PokemonAdapter
import com.example.pokedex.`interface`.CellPokemonClickListener
import com.example.pokedex.model.Pokemon
import com.example.pokedex.ui.pokemonlist.viewmodel.PokemonListViewModel
import kotlinx.coroutines.*
import kotlinx.coroutines.Dispatchers.Main
import org.koin.android.ext.android.inject

class PokemonListActivity : AppCompatActivity(), CellPokemonClickListener {
    private lateinit var loadingGif: ImageView
    private lateinit var intentItem: Intent
    private lateinit var recyclerViewPokemons: RecyclerView
    private lateinit var loadingText: TextView

    private val viewModel: PokemonListViewModel by inject()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_poke_list)

        initViews()
        callLoading()
        setupObservers()
        manageRecyclerView()
        setViewsVisibility()
    }

    private fun setupObservers() {
        viewModel.pokemonList.observe(this) {
            initAdapter(it)
        }
    }

    private fun initViews() {
        this.recyclerViewPokemons = findViewById(R.id.rvPokemonList)
        this.loadingGif = findViewById(R.id.gifLoadingList)
        this.loadingText = findViewById(R.id.txtLoading)
    }

    private fun callLoading() {
        this.loadingGif.visibility = View.VISIBLE
        this.loadingText.visibility = View.VISIBLE
        Glide
            .with(this)
            .asGif()
            .load(R.raw.loading_list)
            .into(loadingGif)
    }

    private fun initAdapter(pokemonList: List<Pokemon>) {
        this.recyclerViewPokemons.adapter = PokemonAdapter(
            pokemonList,
            onCellClickListener = this,
        )
    }

    private fun manageRecyclerView() {
        this.recyclerViewPokemons.layoutManager = LinearLayoutManager(
            this,
            LinearLayoutManager.VERTICAL,
            false
        )
        this.recyclerViewPokemons.setHasFixedSize(true)
    }

    private fun setViewsVisibility() {
        this.loadingGif.visibility = View.GONE
        this.loadingText.visibility = View.GONE
    }

//    override fun onPokemonCellClickListener(data: Pokemon) {
//
//        this.intentItem = Intent(
//            this,
//            PokemonDetailActivity::class.java
//        ).apply {
//            putExtra("id", data.id.toString())
//            putExtra("nome", data.nome)
//            putExtra("tipoPrimario", data.tipoPrimario)
//        }
//
//        startActivity(intentItem)
//    }
}