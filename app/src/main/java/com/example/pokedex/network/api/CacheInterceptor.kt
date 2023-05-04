package com.example.pokedex.network.api

import android.content.Context
import okhttp3.CacheControl
import okhttp3.Interceptor
import okhttp3.Response
import java.util.concurrent.TimeUnit

class CacheInterceptor(
    private val context: Context
) : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
        val originalResponse = chain.proceed(request)

        if (originalResponse.isSuccessful) {
            val cacheControl = CacheControl.Builder()
                .maxAge(7, TimeUnit.DAYS)
                .build()

            return originalResponse.newBuilder()
                .header("Cache-Control", cacheControl.toString())
                .build()
        }

        return originalResponse
    }
}