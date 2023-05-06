package com.example.kitsuapi.ui.fragments.manga.detail

import com.example.kitsuapi.base.BaseViewModel
import com.example.kitsuapi.data.repositories.MangaRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MangaDetailViewModel @Inject constructor(
    private val mangaRepository: MangaRepository
) : BaseViewModel() {

    fun fetchDetailManga(id: String) = mangaRepository.fetchDetailManga(id)
}