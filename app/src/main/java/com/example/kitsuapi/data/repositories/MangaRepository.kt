package com.example.kitsuapi.data.repositories

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.liveData
import com.example.kitsuapi.base.BaseRepository
import com.example.kitsuapi.data.remote.apiservices.MangaApiService
import com.example.kitsuapi.data.repositories.pagingsources.MangaPagingSource
import javax.inject.Inject

class MangaRepository @Inject constructor(
    private val mangaApiService: MangaApiService
): BaseRepository() {

    fun fetchManga() = Pager(
        PagingConfig(pageSize = 20, initialLoadSize = 10)
    ) {
        MangaPagingSource(mangaApiService)
    }.liveData
}
