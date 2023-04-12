package com.example.kitsuapi.data.repositories

import androidx.lifecycle.liveData
import com.example.kitsuapi.Resource
import com.example.kitsuapi.data.remote.apiservices.MangaApiService
import javax.inject.Inject

class MangaRepository @Inject constructor(
    private val mangaApiService: MangaApiService
) {

    fun fetchManga() = liveData {
        emit(Resource.Loading())
        try {
            emit(Resource.Success(mangaApiService.fetchManga()))
        } catch (exception: Exception) {
            emit(Resource.Error(exception.localizedMessage ?: "Error", null))
        }
    }
}
