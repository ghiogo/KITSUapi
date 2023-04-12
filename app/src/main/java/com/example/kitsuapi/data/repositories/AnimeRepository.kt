package com.example.kitsuapi.data.repositories

import androidx.lifecycle.liveData
import com.example.kitsuapi.Resource
import com.example.kitsuapi.data.remote.apiservices.AnimeApiService
import javax.inject.Inject

class AnimeRepository @Inject constructor(
    private val animeApiService: AnimeApiService
) {

    fun fetchAnime() = liveData {
        emit(Resource.Loading())
        try {
            emit(Resource.Success(animeApiService.fetchAnime()))
        } catch (exception: Exception) {
            emit(Resource.Error(exception.localizedMessage ?: "Error", null))
        }
    }
}