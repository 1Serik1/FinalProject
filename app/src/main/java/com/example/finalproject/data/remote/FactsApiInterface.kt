package com.example.finalproject.data.remote

import com.example.finalproject.data.remote.model.FactsApiModel
import retrofit2.Response
import retrofit2.http.GET

interface FactsApiInterface {

    @GET("/api/v2/facts/random?language=en")
    suspend fun getRandomFact(): Response<FactsApiModel>
}