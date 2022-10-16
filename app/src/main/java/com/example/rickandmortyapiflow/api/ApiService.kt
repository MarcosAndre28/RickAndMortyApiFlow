package com.example.rickandmortyapiflow.api


import com.example.rickandmortyapiflow.model.ResponseApi
import retrofit2.http.GET
import com.example.rickandmortyapiflow.util.Constants
import retrofit2.Response
import retrofit2.http.Query

interface ApiService {

    @GET(Constants.END_POINT)
    suspend fun getAllCharacters(
        @Query("page") page: Int
    ): Response<ResponseApi>

}