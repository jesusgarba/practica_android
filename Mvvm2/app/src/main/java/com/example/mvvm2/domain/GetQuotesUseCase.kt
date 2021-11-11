package com.example.mvvm2.domain

import com.example.mvvm2.data.QuoteRepository
import com.example.mvvm2.data.model.QuoteModel

class GetQuotesUseCase {

    private val repository = QuoteRepository()

    suspend operator fun invoke():List<QuoteModel>? = repository.getAllQuotes()
}