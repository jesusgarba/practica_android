package com.example.mvvmdi.core

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitHelper {

    const val URI = "https://drawsomething-59328-default-rtdb.europe-west1.firebasedatabase.app/"

    fun getRetrofit(): Retrofit{
        return Retrofit.Builder()
            .baseUrl(URI)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}