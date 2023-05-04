package com.example.pokedex.network.api

import android.content.Context
import com.example.pokedex.service.PokeService
import okhttp3.Cache
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class PokeApi(
    private val context: Context
) {

    private val cacheSize = (10 * 1024 * 1024).toLong()
    private val cache = Cache(context.cacheDir, cacheSize)

    private val okHttpClient = OkHttpClient.Builder()
        .cache(cache)
        .addInterceptor(CacheInterceptor(context))
        .build()

    fun getPokemonService(): PokeService {
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .build()

        return retrofit.create(PokeService::class.java)
    }

    companion object {
        const val BASE_URL = "https://pokeapi.co/api/v2/"
    }
}