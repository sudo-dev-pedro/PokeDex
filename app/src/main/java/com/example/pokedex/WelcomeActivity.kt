package com.example.pokedex

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.Main
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class WelcomeActivity : AppCompatActivity() {
    private lateinit var btnProsseguir : Button
    private lateinit var campoNomeUsuario : EditText
    private lateinit var pokebolaGif : ImageView
    private lateinit var loadingGif : ImageView
    private lateinit var intentList : Intent
    private lateinit var nomeUsuario : String
    private lateinit var welcomeText : String
    private lateinit var loadingText : TextView
    private lateinit var labelName : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome_screen)
    }

    override fun onResume() {
        super.onResume()

        this.initViews()
        this.insertNameGif()

        btnProsseguir.setOnClickListener{
            nomeUsuario = campoNomeUsuario.text.toString()

            nomeUsuario?.let {
                this.showWelcomeText(nomeUsuario)
                this.setViewsVisibility()
                this.loading()
            }

            CoroutineScope(Main).launch{
                delay(2500)
                this@WelcomeActivity.proceedToPokeList()
            }
        }
    }

    private fun initViews(){
        btnProsseguir = findViewById(R.id.btnProceed)
        campoNomeUsuario = findViewById(R.id.edtNomeUsuario)
        loadingText = findViewById(R.id.txtWelcomeText)
        pokebolaGif = findViewById(R.id.gifPokebola)
        labelName = findViewById(R.id.txtTitle)
        loadingGif = findViewById(R.id.gifLoading)
    }

    fun showWelcomeText(nomeUsuario : String){
        this.welcomeText = getString(R.string.txt_welcome, nomeUsuario)
        this.loadingText.text = welcomeText
    }

    private fun setViewsVisibility() {
        btnProsseguir.visibility = View.GONE
        campoNomeUsuario.visibility = View.GONE
        pokebolaGif.visibility = View.GONE
        labelName.visibility = View.GONE

        loadingGif.visibility = View.VISIBLE
        loadingText.visibility = View.VISIBLE
    }

    private fun loading(){
        Glide
            .with(this)
            .asGif()
            .load(R.raw.img_loading)
            .into(loadingGif)
    }

    private fun insertNameGif(){
        Glide
            .with(this)
            .asGif()
            .load(R.raw.img_insert_name)
            .into(pokebolaGif)
    }

    private fun proceedToPokeList(){
        intentList = Intent(this, PokemonListActivity::class.java)
        startActivity(intentList)
    }
}