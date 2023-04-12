package com.example.kitsuapi.data.remote.apiservices

import com.example.kitsuapi.models.DataItem
import com.example.kitsuapi.models.Response
import retrofit2.http.GET

interface AnimeApiService {

    @GET("anime")
    suspend fun fetchAnime(
    ): Response<DataItem>
}