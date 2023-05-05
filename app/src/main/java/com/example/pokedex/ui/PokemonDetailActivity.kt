//package com.example.pokedex.ui
//
//import androidx.appcompat.app.AppCompatActivity
//import android.os.Bundle
//import android.view.View
//import android.widget.ImageView
//import android.widget.TextView
//import androidx.core.widget.NestedScrollView
//import androidx.viewpager.widget.ViewPager
//import com.bumptech.glide.Glide
//import com.example.pokedex.R
//import com.example.pokedex.adapter.AbasAdapter
//import com.example.pokedex.fragment.AbilitiesFragment
//import com.example.pokedex.fragment.EvolutionFragment
//import com.example.pokedex.fragment.StatsFragment
//import com.example.pokedex.model.PokemonAbilities
//import com.example.pokedex.model.PokemonEvolutions
//import com.example.pokedex.model.PokemonType
//import com.google.android.material.tabs.TabLayout
//import com.example.pokedex.utils.PokemonUtils
//import kotlinx.coroutines.*
//import kotlinx.coroutines.Dispatchers.IO
//
//class PokemonDetailActivity : AppCompatActivity() {
//    private lateinit var adapter : AbasAdapter
//    private lateinit var abilitiesPokemon : ArrayList<PokemonAbilities>
//    private lateinit var evolutionsPokemon : ArrayList<PokemonEvolutions>
//    private lateinit var resistencesPokemon : ArrayList<String>
//    private lateinit var statsPokemon : ArrayList<Int>
//    private lateinit var weaknessesPokemon : ArrayList<String>
//    private lateinit var bundle: Bundle
//    private lateinit var imagemPokemon : ImageView
//    private lateinit var loadingGifDetails : ImageView
//    private lateinit var nestedScrollView: NestedScrollView
//    private lateinit var tabLayout : TabLayout
//    private lateinit var nomePokemon : TextView
//    private lateinit var idPokemon : TextView
//    private lateinit var tipoPrimario : TextView
//    private lateinit var viewPager : ViewPager
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_pokemon_detail)
//
//        initViews()
//        callLoading()
//
//        CoroutineScope(IO).launch {
//            requestPokemonApi()
//        }
//    }
//
//    private suspend fun passDataToUI(dataPokemon: Bundle){
//        withContext(Dispatchers.Main) {
//            delay(2500)
//            setTextViews()
//            setPokemonImage()
//            setNestedBackground()
//            prepareFragments(dataPokemon)
//            startTabLayout()
//            setViewsVisibility()
//        }
//    }
//
//    private suspend fun requestPokemonApi(){
//        val result = getPokemonData()
//        passDataToUI(result)
//    }
//
//    private suspend fun getPokemonData() : Bundle {
//        delay(2000)
//
//        statsPokemon = arrayListOf()
//        weaknessesPokemon = arrayListOf()
//        resistencesPokemon = arrayListOf()
//        abilitiesPokemon = arrayListOf()
//        evolutionsPokemon = arrayListOf()
//
//        val idPokemonIntent : String? = intent.getStringExtra("id")
//        val tipoPrimarioIntent: String? = intent.getStringExtra("tipoPrimario")
//
//        val pokemonData = pokemonApi.getPokemon(idPokemonIntent?.toInt()!!) //Isso não é boa prática!
//
//        statsPokemon.add(pokemonData.stats[0].baseStat)
//        statsPokemon.add(pokemonData.stats[1].baseStat)
//        statsPokemon.add(pokemonData.stats[2].baseStat)
//        statsPokemon.add(pokemonData.stats[3].baseStat)
//        statsPokemon.add(pokemonData.stats[4].baseStat)
//        statsPokemon.add(pokemonData.stats[5].baseStat)
//
//        val damageByType = pokemonApi.getType(pokemonData.types[0].type.id)
//        damageByType.damageRelations.doubleDamageFrom.forEach {
//            weaknessesPokemon.add(it.name)
//        }
//
//        damageByType.damageRelations.halfDamageFrom.forEach {
//            resistencesPokemon.add(it.name)
//        }
//
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
//
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
//
//    private fun initViews(){
//        this.tabLayout = findViewById(R.id.tbLayoutAbas)
//        this.viewPager = findViewById(R.id.viewPager)
//        this.nomePokemon = findViewById(R.id.txtNomePokemon)
//        this.idPokemon = findViewById(R.id.txtIdPokemon)
//        this.tipoPrimario = findViewById(R.id.txtViewPrimaryIconStyle)
//        this.imagemPokemon = findViewById(R.id.imgViewPokemon)
//        this.nestedScrollView = findViewById(R.id.nstScrollView)
//        this.loadingGifDetails = findViewById(R.id.gifLoadingDetails)
//    }
//
//    private fun callLoading(){
//        this.loadingGifDetails.visibility = View.VISIBLE
//        Glide
//            .with(this)
//            .asGif()
//            .load(R.raw.loading_details)
//            .into(loadingGifDetails)
//    }
//
//    private fun setViewsVisibility(){
//        this.loadingGifDetails.visibility = View.GONE
//    }
//
//    private fun setTextViews(){
//        val idPokemonIntent : String? = intent.getStringExtra("id")
//        val nomePokemonIntent : String? = intent.getStringExtra("nome")
//        val tipoPrimarioIntent: String? = intent.getStringExtra("tipoPrimario")
//
//        idPokemonIntent?.let{
//            idPokemon.text = PokemonUtils.makeIDMask(idPokemonIntent.toInt())
//        }
//
//        nomePokemonIntent?.let{
//            nomePokemon.text = PokemonUtils.capitalizeFirstLetterOfPokemon(nomePokemonIntent)
//        }
//
//        tipoPrimarioIntent?.let {
//            tipoPrimario.text = PokemonUtils.capitalizeFirstLetterOfPokemon(tipoPrimarioIntent)
//            tipoPrimario.setBackgroundResource(PokemonType.getDrawableTypeColor(tipoPrimarioIntent))
//            tipoPrimario.setCompoundDrawablesWithIntrinsicBounds(PokemonType.getIconByType(tipoPrimarioIntent) , 0, 0, 0)
//        }
//    }
//
//    private fun setPokemonImage(){
//        val id : String? = intent.getStringExtra("id")
//
//        id?.let{
//            Glide
//                .with(this)
//                .load(PokemonUtils.prepareImages(id.toInt()))
//                .into(imagemPokemon)
//        }
//    }
//
//    private fun setNestedBackground(){
//        val tipoPrimarioIntent: String? = intent.getStringExtra("tipoPrimario")
//
//        tipoPrimarioIntent?.let {
//            nestedScrollView.setBackgroundResource(PokemonType.getThemeByType(tipoPrimarioIntent))
//        }
//    }
//
//    private fun prepareFragments(bundle: Bundle) {
//        this.adapter = AbasAdapter(supportFragmentManager, bundle)
//        adapter.addFragment(StatsFragment(), "Stats", bundle)
//        adapter.addFragment(EvolutionFragment(), "Evolutions", bundle)
//        adapter.addFragment(AbilitiesFragment(), "Abilities", bundle)
//    }
//
//    private fun startTabLayout() {
//
//        this.viewPager.adapter = adapter
//        this.viewPager.addOnPageChangeListener(TabLayout.TabLayoutOnPageChangeListener(tabLayout))
//
//        this.tabLayout.addOnTabSelectedListener(object: TabLayout.OnTabSelectedListener {
//            override fun onTabSelected(tab: TabLayout.Tab?) {
//                tab?.let {
//                    //viewPager.currentItem = tab.position
//                    val tipoPrimarioIntent: String? = intent.getStringExtra("tipoPrimario")
//                    tabLayout.setSelectedTabIndicatorColor(PokemonType.getThemeByType(tipoPrimarioIntent))
//                }
//            }
//
//            override fun onTabUnselected(tab: TabLayout.Tab?) {
//            }
//
//            override fun onTabReselected(tab: TabLayout.Tab?) {
//            }
//        })
//
//        this.tabLayout.setupWithViewPager(this.viewPager)
//    }
//
//}