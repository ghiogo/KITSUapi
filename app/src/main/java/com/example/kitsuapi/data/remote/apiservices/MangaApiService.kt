package com.example.kitsuapi.data.remote.apiservices

import com.example.kitsuapi.models.DataItem
import com.example.kitsuapi.models.Response
import retrofit2.http.GET

interface MangaApiService {

    @GET("manga")
    suspend fun fetchManga(): Response<DataItem>
}