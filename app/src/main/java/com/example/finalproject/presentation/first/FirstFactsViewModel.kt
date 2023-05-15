package com.example.finalproject.presentation.first

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.finalproject.data.local.FactsDataClass
import com.example.finalproject.domain.FactsUseCase
import kotlinx.coroutines.launch

class FirstFactsViewModel: ViewModel() {

    private val factUseCase = FactsUseCase
    val cardCollect = MutableLiveData<ArrayList<FactsDataClass>>()

    fun getCard(){
        viewModelScope.launch {
            cardCollect.postValue(factUseCase.getCard())
        }
    }
}