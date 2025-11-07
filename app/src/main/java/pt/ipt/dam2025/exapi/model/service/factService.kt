package pt.ipt.dam2025.exapi.model.service

import pt.ipt.dam2025.exapi.model.Model
import retrofit2.Call
import retrofit2.http.GET

interface factService {
    @GET("https://dogapi.dog/api/v2/facts")
    fun list(): Call<List<Model>>

}