package com.example.mvvmdi.data.network


import com.example.mvvmdi.data.model.QuoteModel
import retrofit2.Response
import retrofit2.http.GET

interface QuoteApiClient {
    @GET("/.json")
    suspend fun getAllQuotes():Response<List<QuoteModel>>
}