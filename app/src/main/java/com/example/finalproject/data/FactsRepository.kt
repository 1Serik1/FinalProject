package com.example.finalproject.data

import com.example.finalproject.data.remote.FactsApiFactory
import com.example.finalproject.data.remote.model.FactsApiModel

object FactsRepository {

    private val api = FactsApiFactory.factsApi

    suspend fun getFacts(): FactsApiModel? {

        val response = api.getRandomFact()
        if (response.isSuccessful) {
            if (response.body() != null) {
                val body = response.body()
                return body!!
            }
        }

        return null
    }
}