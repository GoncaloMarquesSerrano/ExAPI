package pt.ipt.dam2025.exapi.retrofit

import pt.ipt.dam2025.exapi.model.service.FactService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitInitializer {
    private val retrofit = Retrofit.Builder()
        .baseUrl("https://dogapi.dog/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
    fun factService() = retrofit.create(FactService::class.java)
}