package com.example.mvvm2.data

import com.example.mvvm2.data.model.QuoteModel
import com.example.mvvm2.data.model.QuoteProvider
import com.example.mvvm2.data.network.QuoteService

class QuoteRepository {

    private val api = QuoteService()

    suspend fun getAllQuotes():List<QuoteModel>{
        val response = api.getAllQuotes()
        QuoteProvider.quotes = response
        return response

    }

}