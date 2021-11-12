package com.example.mvvmdi.data


import com.example.mvvmdi.data.model.QuoteModel
import com.example.mvvmdi.data.model.QuoteProvider
import com.example.mvvmdi.data.network.QuoteService
import javax.inject.Inject

class QuoteRepository @Inject constructor(
    private val api: QuoteService,
    private val quoteProvider: QuoteProvider) {

    suspend fun getAllQuotes():List<QuoteModel>{
        val response = api.getAllQuotes()
        quoteProvider.quotes = response
        return response

    }

}