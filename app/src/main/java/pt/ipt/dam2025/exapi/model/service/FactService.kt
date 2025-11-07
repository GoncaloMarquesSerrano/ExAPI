package pt.ipt.dam2025.exapi.model.service

import pt.ipt.dam2025.exapi.model.Fact
import retrofit2.Call
import retrofit2.http.GET

interface FactService {
    @GET("api/v2/facts")
    fun list(): Call<Fact.DogFactResponse>

}