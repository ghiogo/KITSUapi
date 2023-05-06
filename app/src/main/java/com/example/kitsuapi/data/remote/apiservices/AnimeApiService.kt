package com.example.kitsuapi.data.remote.apiservices

import com.example.kitsuapi.models.DataItem
import com.example.kitsuapi.models.Response
import com.example.kitsuapi.models.ResponseDetail
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface AnimeApiService {
    @GET("edge/anime")
    suspend fun fetchAnime(
        @Query("page[limit]") pageLimit: Int,
        @Query("page[offset]") pageOffset: Int
    ): Response<DataItem>
    @GET("edge/anime/{id}")
    suspend fun fetchDetailAnime(
        @Path("id") id: String
    ): ResponseDetail
}