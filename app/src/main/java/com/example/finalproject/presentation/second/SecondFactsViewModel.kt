package com.example.finalproject.presentation.second

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.finalproject.domain.FactsUseCase
import kotlinx.coroutines.launch

class SecondFactsViewModel : ViewModel() {
    private val factsUseCase = FactsUseCase
    val fact = MutableLiveData<String>()

    fun getRandFact() {
        viewModelScope.launch {
            fact.postValue(factsUseCase.getFacts())
        }
    }

}