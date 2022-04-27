package com.example.sistemasolar.vista2

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.example.Data
import com.example.example.Root
import com.example.sistemasolar.service.PlanetsService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class DetailViewModel: ViewModel() {
    private val retrofit= Retrofit.Builder()
        .baseUrl("https://aartek.info/mocks/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    private val service: PlanetsService =retrofit.create(PlanetsService::class.java)

    val planetList= MutableLiveData<List<Data>>()

    fun getPlanetListDetail(){
        val call=service.getPlanetsInfo()
        call.enqueue(object : Callback<Root> {
            override fun onResponse(call: Call<Root>, response: Response<Root>) {
                response.body()?.data!!.let { list ->
                    println("batman")
                    planetList.postValue(list)
                }

            }

            override fun onFailure(call: Call<Root>, t: Throwable) {
                println("picard "+t.message)
                call.cancel()
            }


        })
    }
}