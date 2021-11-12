package com.example.mvvmdi.data.network

import com.example.mvvmdi.core.RetrofitHelper
import com.example.mvvmdi.data.model.QuoteModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject


class QuoteService @Inject constructor(private val api: QuoteApiClient){

    suspend fun getAllQuotes(): List<QuoteModel> {
        return withContext(Dispatchers.IO){
            val response = api.getAllQuotes()
            response.body() ?: emptyList()
        }
    }

}