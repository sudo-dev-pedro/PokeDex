package com.example.pokedex.ui.pokemondetail.view

import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.NestedScrollView
import androidx.viewpager.widget.ViewPager
import com.bumptech.glide.Glide
import com.example.pokedex.R
import com.example.pokedex.adapter.TabsAdapter
import com.example.pokedex.fragment.AbilitiesFragment
import com.example.pokedex.fragment.EvolutionFragment
import com.example.pokedex.fragment.StatsFragment
import com.example.pokedex.model.PokemonType
import com.example.pokedex.utils.PokemonUtils
import com.google.android.material.tabs.TabLayout
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.withContext

class PokemonDetailActivity : AppCompatActivity() {
    private lateinit var adapter: TabsAdapter
    private lateinit var pokemonImage: ImageView
    private lateinit var loadingGif: ImageView
    private lateinit var nestedScrollView: NestedScrollView
    private lateinit var tabLayout: TabLayout
    private lateinit var pokemonName: TextView
    private lateinit var pokemonId: TextView
    private lateinit var primaryType: TextView
    private lateinit var viewPager: ViewPager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pokemon_detail)

        val idPokemonIntent: String? = intent.getStringExtra("id")

        initViews()
        callLoading()

//        CoroutineScope(IO).launch {
//            requestPokemonApi()
//        }
    }

    private suspend fun passDataToUI(dataPokemon: Bundle) {
        withContext(Dispatchers.Main) {
            delay(2500)
            setTextViews()
            setPokemonImage()
            setNestedBackground()
            prepareFragments(dataPokemon)
            startTabLayout()
            setViewsVisibility()
        }
    }

//    private suspend fun requestPokemonApi(){
//        val result = getPokemonData()
//        passDataToUI(result)
//    }

//    private suspend fun getPokemonData() : Bundle {
//        delay(2000)

//        weaknessesPokemon = arrayListOf()
//        resistencesPokemon = arrayListOf()
//        evolutionsPokemon = arrayListOf()

//        val tipoPrimarioIntent: String? = intent.getStringExtra("tipoPrimario")


//        val damageByType = pokemonApi.getType(pokemonData.types[0].type.id)
//        damageByType.damageRelations.doubleDamageFrom.forEach {
//            weaknessesPokemon.add(it.name)
//        }
//
//        damageByType.damageRelations.halfDamageFrom.forEach {
//            resistencesPokemon.add(it.name)
//        }

//        pokemonData.abilities.forEach{
//            val abilityID = pokemonApi.getAbility(it.ability.id)
//            val abilityName = abilityID.name
//            for(i in 0..1){
//                val lang = abilityID.effectEntries[i].language.name
//                val langBoolean = lang.equals("en")
//
//                if(langBoolean == true){
//                    val ability = abilityID.effectEntries[i].effect
//                    abilitiesPokemon.add(PokemonAbilities(abilityName, ability))
//                }
//            }
//        }

//        val chain = pokemonApi.getEvolutionChain(pokemonData.id)
//        //Nome da Espécie
//        //val subChainEvolutionName = chain.chain.species.name
//        val evolution = chain.chain.evolvesTo.forEach{
//            val firstEvolutionName = it.species.name
//            val secondEvolution = it.evolvesTo[0].species.name
//            evolutionsPokemon.add(PokemonEvolutions(firstEvolutionName, secondEvolution))
//        }
//
//        bundle = Bundle().apply {
//            putIntegerArrayList("Stats", statsPokemon)
//            putStringArrayList("Weaknesses", weaknessesPokemon)
//            putStringArrayList("Resistences", resistencesPokemon)
//            putParcelableArrayList("Evolutions", evolutionsPokemon)
//            putParcelableArrayList("Abilities", abilitiesPokemon)
//            putString("Tipo", tipoPrimarioIntent) //Eu recupero isso em algum local?
//        }
//
//        return bundle
//    }

    private fun initViews() {
        this.tabLayout = findViewById(R.id.tbLayoutAbas)
        this.viewPager = findViewById(R.id.viewPager)
        this.pokemonName = findViewById(R.id.txtNomePokemon)
        this.pokemonId = findViewById(R.id.txtIdPokemon)
        this.primaryType = findViewById(R.id.txtViewPrimaryIconStyle)
        this.pokemonImage = findViewById(R.id.imgViewPokemon)
        this.nestedScrollView = findViewById(R.id.nstScrollView)
        this.loadingGif = findViewById(R.id.gifLoadingDetails)
    }

    private fun callLoading() {
        this.loadingGif.visibility = View.VISIBLE
        Glide
            .with(this)
            .asGif()
            .load(R.raw.loading_details)
            .into(loadingGif)
    }

    private fun setViewsVisibility() {
        this.loadingGif.visibility = View.GONE
    }

    private fun setTextViews() {
        val idPokemonIntent: String? = intent.getStringExtra("id")
        val nomePokemonIntent: String? = intent.getStringExtra("nome")
//        val tipoPrimarioIntent: String? = intent.getStringExtra("tipoPrimario")

        idPokemonIntent?.let {
            pokemonId.text = PokemonUtils.makeIDMask(idPokemonIntent.toInt())
        }

        nomePokemonIntent?.let {
            pokemonName.text = PokemonUtils.capitalizeFirstLetterOfPokemon(nomePokemonIntent)
        }

//        tipoPrimarioIntent?.let {
//            tipoPrimario.text = PokemonUtils.capitalizeFirstLetterOfPokemon(tipoPrimarioIntent)
//            tipoPrimario.setBackgroundResource(PokemonType.getDrawableTypeColor(tipoPrimarioIntent))
//            tipoPrimario.setCompoundDrawablesWithIntrinsicBounds(PokemonType.getIconByType(tipoPrimarioIntent) , 0, 0, 0)
//        }
    }

    private fun setPokemonImage() {
        val id: String? = intent.getStringExtra("id")

        id?.let {
            Glide
                .with(this)
                .load(PokemonUtils.prepareImages(id.toInt()))
                .into(pokemonImage)
        }
    }

    private fun setNestedBackground() {
        val tipoPrimarioIntent: String? = intent.getStringExtra("tipoPrimario")

        tipoPrimarioIntent?.let {
            nestedScrollView.setBackgroundResource(PokemonType.getThemeByType(tipoPrimarioIntent))
        }
    }

    private fun prepareFragments(bundle: Bundle) {
        this.adapter = TabsAdapter(supportFragmentManager, bundle)
        adapter.addFragment(StatsFragment(), "Stats", bundle)
        adapter.addFragment(EvolutionFragment(), "Evolutions", bundle)
        adapter.addFragment(AbilitiesFragment(), "Abilities", bundle)
    }

    private fun startTabLayout() {

        this.viewPager.adapter = adapter
        this.viewPager.addOnPageChangeListener(TabLayout.TabLayoutOnPageChangeListener(tabLayout))

        this.tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab?) {
                tab?.let {
                    //viewPager.currentItem = tab.position
                    val tipoPrimarioIntent: String? = intent.getStringExtra("tipoPrimario")
                    tabLayout.setSelectedTabIndicatorColor(
                        PokemonType.getThemeByType(
                            tipoPrimarioIntent
                        )
                    )
                }
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {
            }

            override fun onTabReselected(tab: TabLayout.Tab?) {
            }
        })

        this.tabLayout.setupWithViewPager(this.viewPager)
    }

}