package com.example.mvvmdi.domain

import com.example.mvvmdi.data.QuoteRepository
import com.example.mvvmdi.data.model.QuoteModel
import javax.inject.Inject

class GetQuotesUseCase @Inject constructor(private val repository: QuoteRepository){

    suspend operator fun invoke():List<QuoteModel>? = repository.getAllQuotes()
}