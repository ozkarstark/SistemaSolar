package com.example.sistemasolar.service

import com.example.example.Data
import com.example.example.Root
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface PlanetsService {
    @GET("tests/planetas.json")
    fun getPlanetsInfo() :Call<Root>
}