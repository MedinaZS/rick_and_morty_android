package com.roshka.rickandmortyandroid

import com.roshka.rickandmortyandroid.models.CharactersResponse
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Url

private const val BASE_URL = "https://rickandmortyapi.com/api/"

private val retrofit = Retrofit.Builder()
    .addConverterFactory(GsonConverterFactory.create())
    .baseUrl(BASE_URL)
    .build()


interface APIService {
    @GET("character")
    fun getAllCharacters(): Call<CharactersResponse>

    @GET
    fun getCharacterByName(@Url url: String): Call<CharactersResponse>
}

object Api {
    val retrofitService: APIService by lazy {
        retrofit.create(APIService::class.java)
    }
}
