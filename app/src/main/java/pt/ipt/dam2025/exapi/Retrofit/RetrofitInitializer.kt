package pt.ipt.dam2025.exapi.Retrofit

import pt.ipt.dam2025.exapi.model.service.factService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitInitializer {
    private val retrofit = Retrofit.Builder()
        .baseUrl("http://10.0.2.2/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
    fun noteService() = retrofit.create(factService::class.java)
}