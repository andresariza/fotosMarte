package com.example.fotosdemarte.network

import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit
import retrofit2.http.GET
import kotlinx.serialization.json.Json
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory




private const val BASE_URL = "https://android-kotlin-fun-mars-server.appspot.com/"

private const val PATH ="photos"

private val retrofit = Retrofit.Builder()
   // .addConverterFactory(ScalarsConverterFactory.create())
    .addConverterFactory(Json.asConverterFactory("aplication/json".toMediaType()))
    .baseUrl(BASE_URL)
    .build()

interface MarsApiService {
    @GET(PATH)
    suspend fun getPhotos() : List<MarPhoto>
}

object MarsApi {
    val retrofitService : MarsApiService by lazy {
        retrofit.create(MarsApiService::class.java)
    }
}

