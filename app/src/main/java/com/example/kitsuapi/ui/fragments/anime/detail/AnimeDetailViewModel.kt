package com.example.kitsuapi.ui.fragments.anime.detail

import com.example.kitsuapi.base.BaseViewModel
import com.example.kitsuapi.data.repositories.AnimeRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class AnimeDetailViewModel @Inject constructor(
    private val animeRepository: AnimeRepository
) : BaseViewModel() {

    fun fetchDetailAnime(id: String) = animeRepository.fetchDetailAnime(id)
}