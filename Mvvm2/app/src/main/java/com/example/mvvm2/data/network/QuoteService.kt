package com.example.mvvm2.data.network

import com.example.mvvm2.core.RetrofitHelper
import com.example.mvvm2.data.model.QuoteModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response

class QuoteService{

    private val retrofit = RetrofitHelper.getRetrofit()

    suspend fun getAllQuotes(): List<QuoteModel> {
        return withContext(Dispatchers.IO){
            val response = retrofit.create(QuoteApiClient::class.java).getAllQuotes()
            response.body() ?: emptyList()
        }
    }
}