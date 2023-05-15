package com.example.finalproject.domain

import com.example.finalproject.data.FactsRepository
import com.example.finalproject.data.local.CardDB
import com.example.finalproject.data.local.FactsDataClass

object FactsUseCase {

    private val remoteRepository = FactsRepository
    private val localRep = CardDB()

    suspend fun getFacts(): String {
        return remoteRepository.getFacts()?.text ?: String()
    }

    fun getCard(): ArrayList<FactsDataClass> {

        val listCard = ArrayList<FactsDataClass>()
        listCard.add(localRep.firstFact)
        listCard.add(localRep.secondFact)
        listCard.add(localRep.thirdFact)
        listCard.add(localRep.fourthFact)

        return listCard
    }
}