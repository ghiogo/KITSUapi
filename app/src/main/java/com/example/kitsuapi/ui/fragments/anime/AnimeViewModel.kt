package com.example.kitsuapi.ui.fragments.anime

import androidx.lifecycle.ViewModel
import com.example.kitsuapi.data.repositories.AnimeRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class AnimeViewModel @Inject constructor(
    private val animeRepository: AnimeRepository
) : ViewModel() {

    fun fetchAnime() = animeRepository.fetchAnime()
}