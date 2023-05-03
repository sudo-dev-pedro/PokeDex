package com.example.pokedex.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.example.pokedex.R
import com.example.pokedex.ui.pokemonlist.view.PokemonListActivity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.Main
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class WelcomeActivity : AppCompatActivity() {
    private lateinit var btnAdvance: Button
    private lateinit var userNameField: EditText
    private lateinit var gifPokeball: ImageView
    private lateinit var gifLoading: ImageView
    private lateinit var intentList: Intent
    private lateinit var userName: String
    private lateinit var welcomeText: String
    private lateinit var loadingText: TextView
    private lateinit var labelName: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome_screen)
    }

    override fun onResume() {
        super.onResume()

        this.initViews()
        this.insertNameGif()

        btnAdvance.setOnClickListener {
            userName = userNameField.text.toString()

            userName.let {
                this.showWelcomeText(userName)
                this.setViewsVisibility()
                this.loading()
            }

            CoroutineScope(Main).launch {
                delay(2500)
                this@WelcomeActivity.proceedToPokeList()
            }
        }
    }

    private fun initViews() {
        btnAdvance = findViewById(R.id.btnProceed)
        userNameField = findViewById(R.id.edtNomeUsuario)
        loadingText = findViewById(R.id.txtWelcomeText)
        gifPokeball = findViewById(R.id.gifPokebola)
        labelName = findViewById(R.id.txtTitle)
        gifLoading = findViewById(R.id.gifLoading)
    }

    fun showWelcomeText(nomeUsuario: String) {
        this.welcomeText = getString(R.string.txt_welcome, nomeUsuario)
        this.loadingText.text = welcomeText
    }

    private fun setViewsVisibility() {
        btnAdvance.visibility = View.GONE
        userNameField.visibility = View.GONE
        gifPokeball.visibility = View.GONE
        labelName.visibility = View.GONE

        gifLoading.visibility = View.VISIBLE
        loadingText.visibility = View.VISIBLE
    }

    private fun loading() {
        Glide.with(this).asGif().load(R.raw.img_loading).into(gifLoading)
    }

    private fun insertNameGif() {
        Glide.with(this).asGif().load(R.raw.img_insert_name).into(gifPokeball)
    }

    private fun proceedToPokeList() {
        intentList = Intent(this, PokemonListActivity::class.java)
        startActivity(intentList)
    }
}