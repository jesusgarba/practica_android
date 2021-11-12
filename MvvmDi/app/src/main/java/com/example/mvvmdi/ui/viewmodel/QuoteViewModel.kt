package com.example.mvvmdi.ui.viewmodel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mvvmdi.data.model.QuoteModel
import com.example.mvvmdi.domain.GetQuotesUseCase
import com.example.mvvmdi.domain.GetRandomQuoteUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class QuoteViewModel @Inject constructor(
    val getRandomQuoteUseCase: GetRandomQuoteUseCase,
    val getQuotesUseCase: GetQuotesUseCase
): ViewModel() {

    val quoteModel = MutableLiveData<QuoteModel>()
    val isLoading = MutableLiveData<Boolean>()


    fun onCreate(){
        viewModelScope.launch {
            isLoading.postValue(true)
            val result = getQuotesUseCase()

            if(!result.isNullOrEmpty()){
                quoteModel.postValue(result[0])
                isLoading.postValue(false)
            }
        }
    }

    fun randomQuote(){
        isLoading.postValue(true)
        val quote = getRandomQuoteUseCase()
        if(quote != null){
            quoteModel.postValue(quote!!)
        }
        isLoading.postValue(false)
    }


}